package trabalho.ces.trabalho.ces.backend.services;

import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.mappers.MapperBase;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.repositories.IResultadoRepository;
import trabalho.ces.trabalho.ces.backend.repositories.IUsuarioRepository;
import trabalho.ces.trabalho.ces.backend.viewmodels.Relatorio.OutputRelatorioResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "relatorioService")
public class RelatorioService {

    @Autowired
    IResultadoRepository resultadoRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    MapperBase mapperBase;

    public List<OutputRelatorioResultadoViewModel> BuscarResultados(Integer id){
        List<Resultado> resultados = resultadoRepository.findByProvaidProvaIdProva(id);

        Type type = new TypeToken<ArrayList<OutputRelatorioResultadoViewModel>>() {}.getType();

        List<OutputRelatorioResultadoViewModel> resultadosViewModel = mapperBase.toList(resultados, type);

        return resultadosViewModel;
    }

    public List<OutputUsuarioViewModel> BuscarAlunos(){
        Type type = new TypeToken<ArrayList<OutputUsuarioViewModel>>() {}.getType();
        List<OutputUsuarioViewModel> result = mapperBase.toList(usuarioRepository.findByTipoUsuarioidTipoUsuarioIdTipoUsuario(2), type);
        return result;
    }

    public List<OutputUsuarioViewModel> AlunosPendentes(Integer id){
        Type type = new TypeToken<ArrayList<OutputUsuarioViewModel>>() {}.getType();
        List<OutputUsuarioViewModel> result = mapperBase.toList(usuarioRepository.findByProvaPendente(id), type);
        return result;
    }

}
