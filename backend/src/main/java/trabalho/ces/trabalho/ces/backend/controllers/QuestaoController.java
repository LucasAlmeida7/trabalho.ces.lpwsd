package trabalho.ces.trabalho.ces.backend.controllers;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trabalho.ces.trabalho.ces.backend.classmappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.classmappers.QuestaoIO;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.repositories.QuestaoRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("questao-manager")
public class QuestaoController {

    public QuestaoController(){
    }

    @Autowired
    QuestaoRepository questaoRepository;

    @Autowired
    MapperBase mapperBase;

    @Autowired
    QuestaoIO questaoIO;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/questoes")
    public List<OutputQuestaoViewModel> BuscarQuestoes(){
        Type type = new TypeToken<ArrayList<OutputQuestaoViewModel>>() {}.getType();
        List<OutputQuestaoViewModel> result = mapperBase.toList(questaoRepository.findAll(), type);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/questao/{id}")
    public OutputQuestaoViewModel BuscarQuestao(@PathVariable(value="id") long id){
        return mapperBase.mapTo(questaoRepository.findById(id), OutputQuestaoViewModel.class);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/questao")
    public InputQuestaoViewModel InserirQuestao(@RequestBody InputQuestaoViewModel inputQuestaoViewModel) {
        Questao questao = questaoIO.mapTo(inputQuestaoViewModel);
        questaoRepository.save(questao);
        return inputQuestaoViewModel;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/questao/{id}")
    public void AtualizaQuestao(@PathVariable(value="id") long id, @RequestBody InputQuestaoViewModel inputQuestaoViewModel) {
        Questao questaoId = questaoRepository.findById(id);

        if (questaoId == null) {
            throw new IllegalArgumentException();
        }
        if (questaoId.getIdQuestao() != id) {
            throw new IllegalArgumentException();
        }

        Questao questao = questaoIO.mapTo(inputQuestaoViewModel);
        questao.setIdQuestao(id);
        questaoRepository.save(questao);
    }
}
