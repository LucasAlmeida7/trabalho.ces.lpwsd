package trabalho.ces.trabalho.ces.backend.viewmodels.Questao;

import io.swagger.annotations.ApiModelProperty;

public class InputQuestaoProvaViewModel {

    @ApiModelProperty(value = "Id da questão")
    private Long idQuestao;


    public Long getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }
}
