package trabalho.ces.trabalho.ces.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.repositories.IResultadoRepository;
import trabalho.ces.trabalho.ces.backend.repositories.IUsuarioRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.InputResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.OutputResultadoProvaViewModel;

import java.util.List;

@Component(value = "resultadoService")
public class ResultadoService {

    @Autowired
    IResultadoRepository resultadoRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    MapperBase mapperBase;

    public InputResultadoViewModel Inserir(InputResultadoViewModel inputResultadoViewModel) {
        Resultado resultado = mapperBase.mapTo(inputResultadoViewModel, Resultado.class);
        resultadoRepository.save(resultado);
        return inputResultadoViewModel;
    }

    public OutputResultadoProvaViewModel BuscarPorProva(Integer id){
        OutputResultadoProvaViewModel outputResultadoProvaViewModel = new OutputResultadoProvaViewModel();
        List<Resultado> resultados = resultadoRepository.findByProvaidProvaIdProva(id);
        int concluido = resultados.size();
        int existente = usuarioRepository.findByTipoUsuarioidTipoUsuarioIdTipoUsuario(2).size();

        outputResultadoProvaViewModel
                .setConcluido(existente != 0 ? (100 * concluido) / (existente) : 0);
        outputResultadoProvaViewModel
                .setPendente((existente-concluido) != 0 ? (100 * concluido) / (existente-concluido) : 0);
        return outputResultadoProvaViewModel;
    }
}
