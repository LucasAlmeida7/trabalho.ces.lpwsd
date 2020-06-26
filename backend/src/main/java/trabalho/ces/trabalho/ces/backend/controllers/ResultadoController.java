package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.services.ResultadoService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.InputResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.OutputResultadoProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

@RestController
@RequestMapping("resultado-manager")
public class ResultadoController {

    @Autowired
    ResultadoService resultadoService;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/resultado")
    public InputResultadoViewModel InserirResultado(@RequestBody InputResultadoViewModel inputResultadoViewModel) {
        return resultadoService.Inserir(inputResultadoViewModel);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/resultado/prova/{id}")
    public OutputResultadoProvaViewModel BuscarUsuario(@PathVariable(value="id") Integer id){
        return resultadoService.BuscarPorProva(id);
    }
}
