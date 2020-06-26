package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.repositories.IResultadoRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Grafico.OutputGraficoResultadoViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "graficoService")
public class GraficoService {

    @Autowired
    IResultadoRepository resultadoRepository;

    @Autowired
    MapperBase mapperBase;

    public List<OutputGraficoResultadoViewModel> UltimosResultados(){
       List<Resultado> resultados = resultadoRepository.findTop10ByOrderByIdResultadoDesc();

       Type type = new TypeToken<ArrayList<OutputGraficoResultadoViewModel>>() {}.getType();

       List<OutputGraficoResultadoViewModel> resultadosViewModel = mapperBase.toList(resultados, type);

       return resultadosViewModel;
    }
}
