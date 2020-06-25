package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.enums.FiltroQuestaoEnum;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.repositories.IQuestaoRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "questaoService")
public class QuestaoService {

    @Autowired
    IQuestaoRepository questaoRepository;

    @Autowired
    MapperBase mapperBase;

    public List<GridQuestaoViewModel> BuscarTodos(FiltroQuestaoEnum filtroQuestaoEnum){
        List<Questao> questoes;

        switch (filtroQuestaoEnum){
            case todas:
                questoes = questaoRepository.findAll();
                break;
            case ativadas:
                questoes = questaoRepository.findAllByEstadoQuestao((short)1);
                break;
            case desativadas:
                questoes = questaoRepository.findAllByEstadoQuestao((short)2);
                break;
            default:
                throw new IllegalArgumentException();
        }

        Type type = new TypeToken<ArrayList<GridQuestaoViewModel>>() {}.getType();
        List<GridQuestaoViewModel> result = mapperBase.toList(questoes, type);
        return result;
    }

    public OutputQuestaoViewModel BuscarId(long id){
        return mapperBase.mapTo(questaoRepository.findById(id), OutputQuestaoViewModel.class);
    }

    public InputQuestaoViewModel Inserir(InputQuestaoViewModel inputQuestaoViewModel) {

        if(inputQuestaoViewModel.getIdTipoQuestao().toString() == "2"){
            inputQuestaoViewModel.setAlternativaA("");
            inputQuestaoViewModel.setAlternativaB("");
            inputQuestaoViewModel.setAlternativaC("");
            inputQuestaoViewModel.setAlternativaD("");
            inputQuestaoViewModel.setAlternativaE("");
            inputQuestaoViewModel.setAlternativaCorreta(null);
        }

        Questao questao = mapperBase.mapTo(inputQuestaoViewModel, Questao.class);
        questaoRepository.save(questao);
        return inputQuestaoViewModel;
    }

    public OutputQuestaoViewModel Atualizar(long id, InputQuestaoViewModel inputQuestaoViewModel) {
        Questao questaoId = questaoRepository.findById(id);

        if (questaoId == null) {
            throw new IllegalArgumentException();
        }
        if (questaoId.getIdQuestao() != id) {
            throw new IllegalArgumentException();
        }

        Questao questao = mapperBase.mapTo(inputQuestaoViewModel, Questao.class);
        questao.setIdQuestao(id);
        questaoRepository.save(questao);

        return mapperBase.mapTo(questao, OutputQuestaoViewModel.class);
    }
}
