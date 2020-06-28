package trabalho.ces.trabalho.ces.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.repositories.IResultadoRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.InputResultadoViewModel;

@Component(value = "resultadoService")
public class ResultadoService {

    @Autowired
    IResultadoRepository resultadoRepository;

    @Autowired
    MapperBase mapperBase;

    public InputResultadoViewModel Inserir(InputResultadoViewModel inputResultadoViewModel) {
        Resultado resultado = mapperBase.mapTo(inputResultadoViewModel, Resultado.class);
        resultadoRepository.save(resultado);
        return inputResultadoViewModel;
    }
}
