package trabalho.ces.trabalho.ces.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.classmappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Prova;
import trabalho.ces.trabalho.ces.backend.repositories.IProvaRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.InputProvaViewModel;

@Component(value = "provaService")
public class ProvaService {

    @Autowired
    IProvaRepository iProvaRepository;

    @Autowired
    MapperBase mapperBase;

    public InputProvaViewModel Inserir(InputProvaViewModel inputProvaViewModel) {
        Prova prova = mapperBase.mapTo(inputProvaViewModel, Prova.class);
        iProvaRepository.save(prova);
        return inputProvaViewModel;
    }
}
