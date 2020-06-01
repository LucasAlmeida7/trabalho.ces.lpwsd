package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.classmappers.UsuarioMapper;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.repositories.UsuarioRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InserirUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.UsuarioViewModel;

import java.util.List;

@RestController
@RequestMapping("value=/api")
public class UsuarioController {

    UsuarioMapper usuarioMapper;

    public UsuarioController(){
        usuarioMapper = new UsuarioMapper();
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> Usuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario Usuario(@PathVariable(value="id") long id){
        return usuarioRepository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/usuario")
    public Usuario InserirUsuario(@RequestBody InserirUsuarioViewModel inserirUsuarioViewModel) {
        return usuarioRepository.save(usuarioMapper.ToNewModel(inserirUsuarioViewModel));
    }

    @DeleteMapping("/usuario/{id}")
    public void RemoverUsuario(@PathVariable(value="id") long id){
        usuarioRepository.deleteById(id);
    }

    @PutMapping("/usuario")
    public void AtualizaUsuario(@RequestBody UsuarioViewModel usuarioViewModel) {
        Usuario usuario = usuarioRepository.findById(usuarioViewModel.getIdUsuario());
        usuarioRepository.save(usuarioMapper.ToModel(usuario, usuarioViewModel));
    }

    @GetMapping("/usuario/login/")
    public Usuario Login(@PathVariable(value="id") long id){
        return usuarioRepository.findById(id);
    }
}
