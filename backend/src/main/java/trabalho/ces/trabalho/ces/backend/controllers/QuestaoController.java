package trabalho.ces.trabalho.ces.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import trabalho.ces.trabalho.ces.backend.enums.FiltroQuestaoEnum;
import trabalho.ces.trabalho.ces.backend.services.QuestaoService;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.util.List;

@RestController
@RequestMapping("questao-manager")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/questoes/{filtro}")
    public List<GridQuestaoViewModel> BuscarQuestoes(@PathVariable(value="filtro") FiltroQuestaoEnum filtroQuestaoEnum){
        return questaoService.BuscarTodos(filtroQuestaoEnum);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/questao/{id}")
    public OutputQuestaoViewModel BuscarQuestao(@PathVariable(value="id") long id){
        return questaoService.BuscarId(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/questao")
    public InputQuestaoViewModel InserirQuestao(@RequestBody InputQuestaoViewModel inputQuestaoViewModel) {
        return questaoService.Inserir(inputQuestaoViewModel);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/questao/{id}")
    public OutputQuestaoViewModel AtualizaQuestao(@PathVariable(value="id") long id, @RequestBody InputQuestaoViewModel inputQuestaoViewModel) {
        return questaoService.Atualizar(id, inputQuestaoViewModel);
    }
}