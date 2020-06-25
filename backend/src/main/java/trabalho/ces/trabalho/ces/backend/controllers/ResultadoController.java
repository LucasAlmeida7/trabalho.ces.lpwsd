package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.services.ResultadoService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.InputResultadoViewModel;

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

}
