package trabalho.ces.trabalho.ces.backend.classmappers;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.models.Questao;
import trabalho.ces.trabalho.ces.backend.models.TipoQuestao;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoViewModel;

@Component("questaoIO")
public class QuestaoIO {

    private ModelMapper modelMapper;

    final Converter<InputQuestaoViewModel, Questao> questaoConverter
            = new Converter<InputQuestaoViewModel, Questao>() {

        @Override
        public Questao convert(MappingContext<InputQuestaoViewModel, Questao> context) {

            InputQuestaoViewModel inputQuestaoViewModel = context.getSource();

            Questao questao = new Questao();
            questao.setDescricaoQuestao(inputQuestaoViewModel.getDescricaoQuestao());
            questao.setAlternativaA(inputQuestaoViewModel.getAlternativaA());
            questao.setAlternativaB(inputQuestaoViewModel.getAlternativaB());
            questao.setAlternativaC(inputQuestaoViewModel.getAlternativaC());
            questao.setAlternativaD(inputQuestaoViewModel.getAlternativaD());
            questao.setAlternativaE(inputQuestaoViewModel.getAlternativaE());
            questao.setAlternativaCorreta(inputQuestaoViewModel.getAlternativaCorreta());
            questao.setEstadoQuestao(inputQuestaoViewModel.getEstadoQuestao());
            TipoQuestao tipoQuestao = new TipoQuestao();
            tipoQuestao.setIdTipoQuestao(inputQuestaoViewModel.getIdTipoQuestao());
            questao.setTipoQuestaoidTipoQuestao(tipoQuestao);

            return questao;
        }
    };

    public QuestaoIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(questaoConverter);
    }

    public Questao mapTo(InputQuestaoViewModel inputQuestaoViewModel) {
        return this.modelMapper.map(inputQuestaoViewModel, Questao.class);
    }
}
