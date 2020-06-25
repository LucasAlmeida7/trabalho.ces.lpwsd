package trabalho.ces.trabalho.ces.backend.viewmodels.Prova;

import io.swagger.annotations.ApiModelProperty;
import trabalho.ces.trabalho.ces.backend.viewmodels.Questao.InputQuestaoProvaViewModel;

import java.util.Date;
import java.util.List;

public class InputProvaViewModel {

    @ApiModelProperty(value = "Data da prova", required = true)
    private Date dataProva;

    @ApiModelProperty(value = "Questões da Prova", required = true)
    private List<InputQuestaoProvaViewModel> questoes;


    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public List<InputQuestaoProvaViewModel> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<InputQuestaoProvaViewModel> questoes) {
        this.questoes = questoes;
    }
}
