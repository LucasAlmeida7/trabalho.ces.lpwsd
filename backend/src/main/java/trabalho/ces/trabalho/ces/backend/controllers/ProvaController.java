package trabalho.ces.trabalho.ces.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.services.ProvaService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.GridProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.InputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.OutputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.util.List;

@RestController
@RequestMapping("prova-manager")
public class ProvaController {

    @Autowired
    ProvaService provaService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/provas")
    public List<GridProvaViewModel> BuscarProvas(){
        return provaService.BuscarTodos();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/prova/{id}")
    public OutputProvaViewModel BuscarProva(@PathVariable(value="id") Integer id){
        return provaService.BuscarId(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/prova")
    public OutputProvaViewModel InserirProva(@RequestBody InputProvaViewModel inputProvaViewModel) {
        return provaService.Inserir(inputProvaViewModel);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/prova/{id}")
    public OutputProvaViewModel AtualizaProva(@PathVariable(value="id") Integer id, @RequestBody InputProvaViewModel inputProvaViewModel) {
        return provaService.Atualizar(id, inputProvaViewModel);
    }
}
