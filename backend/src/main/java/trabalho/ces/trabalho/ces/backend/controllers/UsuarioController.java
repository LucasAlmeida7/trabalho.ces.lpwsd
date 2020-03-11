package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("value=/api")
public class UsuarioController {

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

    @PostMapping("/usuario")
    public Usuario InserirUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void RemoverUsuario(@PathVariable(value="id") long id){
        usuarioRepository.deleteById(id);
    }

    @PutMapping("/usuario")
    public void AtualizaUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
