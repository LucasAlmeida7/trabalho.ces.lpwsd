package trabalho.ces.trabalho.ces.backend.viewmodels.Prova;

import io.swagger.annotations.ApiModelProperty;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.OutputQuestaoViewModel;

import java.util.Date;
import java.util.List;

public class OutputProvaViewModel {
    @ApiModelProperty(value = "Data da prova")
    private Date dataProva;

    @ApiModelProperty(value = "Questões da Prova")
    private List<OutputQuestaoViewModel> questoes;

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public List<OutputQuestaoViewModel> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<OutputQuestaoViewModel> questoes) {
        this.questoes = questoes;
    }
}
