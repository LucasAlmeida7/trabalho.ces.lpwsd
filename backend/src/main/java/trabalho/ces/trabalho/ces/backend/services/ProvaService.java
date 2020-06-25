package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Prova;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.repositories.IProvaRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.GridProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.InputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.OutputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "provaService")
public class ProvaService {

    @Autowired
    IProvaRepository provaRepository;

    @Autowired
    MapperBase mapperBase;

    public List<GridProvaViewModel> BuscarTodos(){
        Type type = new TypeToken<ArrayList<GridProvaViewModel>>() {}.getType();
        List<GridProvaViewModel> result = mapperBase.toList(provaRepository.findAll(), type);
        return result;
    }

    public OutputProvaViewModel BuscarId(Integer id){
        Prova prova = provaRepository.findById(id).orElse(new Prova());;

        OutputProvaViewModel outputProvaViewModel =
                mapperBase.mapTo(prova, OutputProvaViewModel.class);

        Type type = new TypeToken<ArrayList<OutputQuestaoViewModel>>() {}.getType();
        List<OutputQuestaoViewModel> outputQuestaoViewModel = mapperBase.toList(prova.getQuestaoList(), type);
        outputProvaViewModel.setQuestoes(outputQuestaoViewModel);

        return outputProvaViewModel;
    }

    public OutputProvaViewModel Inserir(InputProvaViewModel inputProvaViewModel) {
        if(inputProvaViewModel.getQuestoes().size() == 0)
            throw new IllegalArgumentException("Nenhuma questão foi informada.");

        Prova prova = new Prova();
        prova.setDataProva(inputProvaViewModel.getDataProva());
        Type type = new TypeToken<ArrayList<Questao>>() {}.getType();
        prova.setQuestaoList(mapperBase.toList(inputProvaViewModel.getQuestoes(), type));
        provaRepository.save(prova);
        return mapperBase.mapTo(prova, OutputProvaViewModel.class);
    }

    public OutputProvaViewModel Atualizar(Integer id, InputProvaViewModel inputProvaViewModel) {
        Prova prova = mapperBase.mapTo(inputProvaViewModel, Prova.class);
        Type type = new TypeToken<ArrayList<Questao>>() {}.getType();
        prova.setQuestaoList(mapperBase.toList(inputProvaViewModel.getQuestoes(), type));
        prova.setIdProva(id);
        provaRepository.save(prova);

        return mapperBase.mapTo(prova, OutputProvaViewModel.class);
    }
}
