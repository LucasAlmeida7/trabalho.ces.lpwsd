package trabalho.ces.trabalho.ces.backend.controllers;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.classmappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.classmappers.UsuarioIO;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.repositories.UsuarioRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InputUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.LoginUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuario-manager")
public class UsuarioController {

    public UsuarioController(){
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    MapperBase mapperBase;

    @Autowired
    UsuarioIO usuarioIO;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/usuarios")
    public List<OutputUsuarioViewModel> BuscarUsuarios(){
        Type type = new TypeToken<ArrayList<OutputUsuarioViewModel>>() {}.getType();
        List<OutputUsuarioViewModel> result = mapperBase.toList(usuarioRepository.findAll(), type);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/usuario/{id}")
    public OutputUsuarioViewModel BuscarUsuario(@PathVariable(value="id") long id){
        return mapperBase.mapTo(usuarioRepository.findById(id), OutputUsuarioViewModel.class);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/usuario")
    public InputUsuarioViewModel InserirUsuario(@RequestBody InputUsuarioViewModel inputUsuarioViewModel) {
        Usuario usuario = usuarioIO.mapTo(inputUsuarioViewModel);
        usuarioRepository.save(usuario);
        return inputUsuarioViewModel;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/usuario/{id}")
    public void RemoverUsuario(@PathVariable(value="id") long id){
        usuarioRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/usuario/{id}")
    public void AtualizaUsuario(@PathVariable(value="id") long id, @RequestBody InputUsuarioViewModel inputUsuarioViewModel) {
        Usuario usuarioId = usuarioRepository.findById(id);

        if (usuarioId == null) {
            throw new IllegalArgumentException();
        }
        if (usuarioId.getIdUsuario() != id) {
            throw new IllegalArgumentException();
        }

        Usuario usuario = usuarioIO.mapTo(inputUsuarioViewModel);
        usuario.setIdUsuario(id);
        usuarioRepository.save(usuario);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/usuario/login/")
    public Usuario LoginUsuario(@RequestBody LoginUsuarioViewModel loginUsuarioViewModel){
        Usuario usuario = usuarioRepository.findFirstByEmailUsuarioAndSenhaUsuario(loginUsuarioViewModel.getEmailUsuario(), loginUsuarioViewModel.getSenhaUsuario());
        return usuario;
    }
}
