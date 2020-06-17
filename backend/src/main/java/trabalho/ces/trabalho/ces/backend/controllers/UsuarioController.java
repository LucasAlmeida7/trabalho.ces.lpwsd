package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.services.UsuarioService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InputUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.LoginUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.util.List;

@RestController
@RequestMapping("usuario-manager")
public class UsuarioController {

    public UsuarioController(){
    }

    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/usuarios")
    public List<OutputUsuarioViewModel> BuscarUsuarios(){
        return usuarioService.BuscarTodos();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/usuario/{id}")
    public OutputUsuarioViewModel BuscarUsuario(@PathVariable(value="id") long id){
        return usuarioService.BuscarId(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/usuario")
    public InputUsuarioViewModel InserirUsuario(@RequestBody InputUsuarioViewModel inputUsuarioViewModel) {
        return usuarioService.Inserir(inputUsuarioViewModel);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> RemoverUsuario(@PathVariable(value="id") long id){
        return usuarioService.Remover(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/usuario/{id}")
    public OutputUsuarioViewModel AtualizaUsuario(@PathVariable(value="id") long id, @RequestBody InputUsuarioViewModel inputUsuarioViewModel) {
        return usuarioService.Atualizar(id, inputUsuarioViewModel);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/usuario/login/")
    public OutputUsuarioViewModel LoginUsuario(@RequestBody LoginUsuarioViewModel loginUsuarioViewModel){
        return usuarioService.Login(loginUsuarioViewModel);
    }
}
