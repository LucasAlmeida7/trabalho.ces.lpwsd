package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.classmappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "questaoService")
public class QuestaoService {

    @Autowired
    trabalho.ces.trabalho.ces.backend.repositories.IQuestaoRepository IQuestaoRepository;

    @Autowired
    MapperBase mapperBase;

    public List<GridQuestaoViewModel> BuscarTodos(){
        Type type = new TypeToken<ArrayList<GridQuestaoViewModel>>() {}.getType();
        List<GridQuestaoViewModel> result = mapperBase.toList(IQuestaoRepository.findAll(), type);
        return result;
    }

    public OutputQuestaoViewModel BuscarId(long id){
        return mapperBase.mapTo(IQuestaoRepository.findById(id), OutputQuestaoViewModel.class);
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
        IQuestaoRepository.save(questao);
        return inputQuestaoViewModel;
    }

    public OutputQuestaoViewModel Atualizar(long id, InputQuestaoViewModel inputQuestaoViewModel) {
        Questao questaoId = IQuestaoRepository.findById(id);

        if (questaoId == null) {
            throw new IllegalArgumentException();
        }
        if (questaoId.getIdQuestao() != id) {
            throw new IllegalArgumentException();
        }

        Questao questao = mapperBase.mapTo(inputQuestaoViewModel, Questao.class);
        questao.setIdQuestao(id);
        IQuestaoRepository.save(questao);

        return mapperBase.mapTo(questao, OutputQuestaoViewModel.class);
    }
}
