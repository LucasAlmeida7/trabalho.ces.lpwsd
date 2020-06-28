package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.repositories.IResultadoRepository;
import trabalho.ces.trabalho.ces.backend.repositories.IUsuarioRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Grafico.OutputGraficoResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.OutputResultadoProvaViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "graficoService")
public class GraficoService {

    @Autowired
    IResultadoRepository resultadoRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    MapperBase mapperBase;

    public List<OutputGraficoResultadoViewModel> UltimosResultados(Integer id){
       List<Resultado> resultados = resultadoRepository.findTop10ByProvaidProvaIdProvaOrderByIdResultadoDesc(id);

       Type type = new TypeToken<ArrayList<OutputGraficoResultadoViewModel>>() {}.getType();

       List<OutputGraficoResultadoViewModel> resultadosViewModel = mapperBase.toList(resultados, type);

       return resultadosViewModel;
    }

    public OutputResultadoProvaViewModel Pendentes(Integer id){
        OutputResultadoProvaViewModel outputResultadoProvaViewModel = new OutputResultadoProvaViewModel();
        List<Resultado> resultados = resultadoRepository.findByProvaidProvaIdProva(id);
        int concluido = resultados.size();
        int existente = usuarioRepository.findByTipoUsuarioidTipoUsuarioIdTipoUsuario(2).size();

        outputResultadoProvaViewModel
                .setConcluido(existente != 0 ? (100 * concluido) / (existente) : 0);
        outputResultadoProvaViewModel
                .setPendente((existente-concluido) != 0 ? (100 * (existente-concluido)) / (existente) : 0);
        return outputResultadoProvaViewModel;
    }
}
