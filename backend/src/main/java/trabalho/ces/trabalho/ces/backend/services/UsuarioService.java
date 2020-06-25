package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.repositories.IUsuarioRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InputUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.LoginUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "usuarioService")
public class UsuarioService {

    @Autowired
    IUsuarioRepository IUsuarioRepository;

    @Autowired
    MapperBase mapperBase;

    public List<OutputUsuarioViewModel> BuscarTodos(){
        Type type = new TypeToken<ArrayList<OutputUsuarioViewModel>>() {}.getType();
        List<OutputUsuarioViewModel> result = mapperBase.toList(IUsuarioRepository.findAll(), type);
        return result;
    }

    public OutputUsuarioViewModel BuscarId(long id){
        return mapperBase.mapTo(IUsuarioRepository.findById(id), OutputUsuarioViewModel.class);
    }

    public InputUsuarioViewModel Inserir(InputUsuarioViewModel inputUsuarioViewModel) {
        Usuario usuarioExistente = IUsuarioRepository.findFirstByEmailUsuario(inputUsuarioViewModel.getEmailUsuario());

        if (usuarioExistente != null) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado para este e-mail.");
        }

        Usuario usuario = mapperBase.mapTo(inputUsuarioViewModel, Usuario.class);
        IUsuarioRepository.save(usuario);

        return inputUsuarioViewModel;
    }

    public ResponseEntity<String> Remover(long id){

        if(IUsuarioRepository.findById(id) == null)
            return new ResponseEntity<>("O usuário informado, não existe.", HttpStatus.BAD_REQUEST);

        IUsuarioRepository.deleteById(id);

        return ResponseEntity.ok("Usuário removido com sucesso!");
    }

    public OutputUsuarioViewModel Atualizar(long id, InputUsuarioViewModel inputUsuarioViewModel) {
        Usuario usuarioId = IUsuarioRepository.findById(id);

        if (usuarioId == null) {
            throw new IllegalArgumentException();
        }

        if (usuarioId.getIdUsuario() != id) {
            throw new IllegalArgumentException();
        }

        Usuario usuario = mapperBase.mapTo(inputUsuarioViewModel, Usuario.class);
        usuario.setIdUsuario(id);
        IUsuarioRepository.save(usuario);

        return mapperBase.mapTo(usuario, OutputUsuarioViewModel.class);
    }

    public OutputUsuarioViewModel Login(LoginUsuarioViewModel loginUsuarioViewModel){
        Usuario usuario = IUsuarioRepository.findFirstByEmailUsuarioAndSenhaUsuario(loginUsuarioViewModel.getEmailUsuario(), loginUsuarioViewModel.getSenhaUsuario());

        //if (usuario == null) {
         //   throw new ExecutionException();
        //}

        return mapperBase.mapTo(usuario, OutputUsuarioViewModel.class);
    }
}
