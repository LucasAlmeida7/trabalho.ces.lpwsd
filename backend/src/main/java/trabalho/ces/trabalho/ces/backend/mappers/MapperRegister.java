package trabalho.ces.trabalho.ces.backend.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.models.Prova;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.viewmodels.Grafico.OutputGraficoResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.GridProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.OutputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Relatorio.OutputRelatorioResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Resultado.InputResultadoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InputUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperRegister")
public final class MapperRegister {

    protected ModelMapper modelMapper;

    public MapperRegister() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.modelMapper = modelMapper;
        RegisterUsuario();
        RegisterQuestao();
        RegisterProva();
        RegisterResultado();
    }

    public void RegisterUsuario(){
        // InputUsuarioViewModel -- > Usuario
        modelMapper.addMappings(new PropertyMap<InputUsuarioViewModel, Usuario>() {
            @Override
            protected void configure() {
                map().setNomeUsuario(source.getNomeUsuario());
                map().setEmailUsuario(source.getEmailUsuario());
                map().setSenhaUsuario(source.getSenhaUsuario());
                map().getTipoUsuarioidTipoUsuario().setIdTipoUsuario(source.getIdTipoUsuario());
            }
        });

        // OutputUsuarioViewModel -- > Usuario
        modelMapper.addMappings(new PropertyMap<Usuario, OutputUsuarioViewModel>() {
            @Override
            protected void configure() {
                map().setNomeUsuario(source.getNomeUsuario());
                map().setEmailUsuario(source.getEmailUsuario());
                map().setIdTipoUsuario((source.getTipoUsuarioidTipoUsuario().getIdTipoUsuario()));
            }
        });

    }

    public void RegisterQuestao(){
        // InputQuestaoViewModel -- > Questao
        modelMapper.addMappings(new PropertyMap<InputQuestaoViewModel, Questao>() {
            @Override
            protected void configure() {
                map().setDescricaoQuestao(source.getDescricaoQuestao());
                map().setAlternativaA(source.getAlternativaA());
                map().setAlternativaB(source.getAlternativaB());
                map().setAlternativaC(source.getAlternativaC());
                map().setAlternativaD(source.getAlternativaD());
                map().setAlternativaE(source.getAlternativaE());
                map().setAlternativaCorreta(source.getAlternativaCorreta());
                map().setEstadoQuestao(source.getEstadoQuestao());
                map().getTipoQuestaoidTipoQuestao().setIdTipoQuestao(source.getIdTipoQuestao());
            }
        });

        // OutputQuestaoViewModel -- > Questao
        modelMapper.addMappings(new PropertyMap<Questao, OutputQuestaoViewModel>() {
            @Override
            protected void configure() {
                map().setDescricaoQuestao(source.getDescricaoQuestao());
                map().setAlternativaA(source.getAlternativaA());
                map().setAlternativaB(source.getAlternativaB());
                map().setAlternativaC(source.getAlternativaC());
                map().setAlternativaD(source.getAlternativaD());
                map().setAlternativaE(source.getAlternativaE());
                map().setAlternativaCorreta(source.getAlternativaCorreta());
                map().setEstadoQuestao(source.getEstadoQuestao());
                map().setIdTipoQuestao((source.getTipoQuestaoidTipoQuestao().getIdTipoQuestao()));
            }
        });

        // Questao -- > GridQuestaoViewModel
        modelMapper.addMappings(new PropertyMap<Questao, GridQuestaoViewModel>() {
            @Override
            protected void configure() {
                map().setEstadoQuestao(source.descricaoEstado());
                map().setNomeTipoQuestao(source.getTipoQuestaoidTipoQuestao().getNomeTipoQuestao());
            }
        });

        // QuestaoProvaViewModel -- > Questao
        modelMapper.addMappings(new PropertyMap<InputQuestaoProvaViewModel, Questao>() {
            @Override
            protected void configure() {
                map().setIdQuestao(source.getIdQuestao());
            }
        });
    }

    public void RegisterProva(){

        // OutputProvaViewModel -- > Prova
        modelMapper.addMappings(new PropertyMap<Prova, OutputProvaViewModel>() {
            @Override
            protected void configure() {
                map().setDataProva(source.getDataProva());
            }
        });

        // Prova -- > GridProvaViewModel
        modelMapper.addMappings(new PropertyMap<Prova, GridProvaViewModel>() {
            @Override
            protected void configure() {
                map().setDataProva(source.getDataString());
                map().setNumQuestoes(source.getNumeroQuestoes());
            }
        });
    }

    public void RegisterResultado(){

        // InputResultadoViewModel -- > Resultado
        modelMapper.addMappings(new PropertyMap<InputResultadoViewModel, Resultado>() {
            @Override
            protected void configure() {
                map().setValorObtido(source.getValorObtido());
                map().getProvaidProva().setIdProva(source.getIdProva());
                map().getUsuarioidUsuario().setIdUsuario(source.getIdUsuario());
            }
        });

        // Resultado --> OutputGraficoResultadoViewModel
        modelMapper.addMappings(new PropertyMap<Resultado, OutputGraficoResultadoViewModel>() {
            @Override
            protected void configure() {
                map().setIdProva(source.getProvaidProva().getIdProva());
                map().setNomeUsuario(source.getUsuarioidUsuario().getNomeUsuario());
                map().setResultadoPorcentagem(source.getValorPorcentagem());
            }
        });

        // Resultado --> OutputRelatorioResultadoViewModel
        modelMapper.addMappings(new PropertyMap<Resultado, OutputRelatorioResultadoViewModel>() {
            @Override
            protected void configure() {
                map().setNomeUsuario(source.getUsuarioidUsuario().getNomeUsuario());
                map().setValorObtido(source.getValorObtido());
                map().setNumeroQuestoes(source.getProvaidProva().getNumeroQuestoes());
            }
        });
    }

    /**
     * Maps the source to destination class.
     *
     * @param source    Source.
     * @param destClass Destination class.
     * @return Instance of destination class.
     */
    public <S, D> D mapTo(S source, Class<D> destClass) {
        return this.modelMapper.map(source, destClass);
    }

    /**
     * Converts the source list to a destination list mapping the source items to
     * destination type items.
     *
     * @param source    Source items.
     * @param destClass Destination class.
     * @return List of instances of destination type.
     */
    public <S, D> List<D> toList(List<S> source, Type destClass) {
        return this.modelMapper.map(source, destClass);
    }
}