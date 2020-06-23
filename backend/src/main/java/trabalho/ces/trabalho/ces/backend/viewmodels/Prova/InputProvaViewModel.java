package trabalho.ces.trabalho.ces.backend.viewmodels.Prova;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class InputProvaViewModel {

    @ApiModelProperty(value = "Data da prova")
    private Date dataProva;

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }
}
