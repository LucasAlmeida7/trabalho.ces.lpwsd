package trabalho.ces.trabalho.ces.backend.viewmodels.Prova;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class GridProvaViewModel {

    @ApiModelProperty(value = "Id da prova")
    private Integer idProva;

    @ApiModelProperty(value = "Data da prova")
    private String dataProva;

    @ApiModelProperty(value = "Número de Questões")
    private Integer numQuestoes;

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

    public Integer getNumQuestoes() {
        return numQuestoes;
    }

    public void setNumQuestoes(Integer numQuestoes) {
        this.numQuestoes = numQuestoes;
    }
}
