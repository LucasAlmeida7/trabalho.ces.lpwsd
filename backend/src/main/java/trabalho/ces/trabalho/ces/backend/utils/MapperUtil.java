package trabalho.ces.trabalho.ces.backend.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.models.Prova;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.InputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Prova.OutputProvaViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.GridQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InputUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.OutputUsuarioViewModel;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperUtil")
public final class MapperUtil {

    protected ModelMapper modelMapper;

    public MapperUtil() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.modelMapper = modelMapper;
        RegisterUsuario();
        RegisterQuestao();
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
                map().setSenhaUsuario(source.getSenhaUsuario());
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

    }

    public void RegisterProva(){

        // InputProvaViewModel -- > Prova
        modelMapper.addMappings(new PropertyMap<InputProvaViewModel, Prova>() {
            @Override
            protected void configure() {
                map().setDataProva(source.getDataProva());
            }
        });

        // OutputProvaViewModel -- > Prova
        modelMapper.addMappings(new PropertyMap<Prova, OutputProvaViewModel>() {
            @Override
            protected void configure() {
                map().setDataProva(source.getDataProva());
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