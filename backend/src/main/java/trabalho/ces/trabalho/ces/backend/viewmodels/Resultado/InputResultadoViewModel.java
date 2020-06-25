package trabalho.ces.trabalho.ces.backend.viewmodels.Resultado;

import io.swagger.annotations.ApiModelProperty;

public class InputResultadoViewModel {

    @ApiModelProperty(value = "Valor obtido do resultado")
    private double valorObtido;

    @ApiModelProperty(value = "Prova do resultado")
    private Integer idProva;

    @ApiModelProperty(value = "Usuário do resultado")
    private long idUsuario;


    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
