package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.services.ProvaService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.InputProvaViewModel;

@RestController
@RequestMapping("prova-manager")
public class ProvaController {

    @Autowired
    ProvaService provaService;

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/usuario")
    public InputProvaViewModel InserirProva(@RequestBody InputProvaViewModel inputProvaViewModel) {
        return provaService.Inserir(inputProvaViewModel);
    }

}
