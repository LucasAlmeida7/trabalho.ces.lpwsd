package trabalho.ces.trabalho.ces.backend.viewmodels.Grafico;

import io.swagger.annotations.ApiModelProperty;

public class OutputGraficoResultadoViewModel {

    @ApiModelProperty(value = "Id da prova")
    private Integer idProva;

    @ApiModelProperty(value = "Nome do usuário")
    private String nomeUsuario;

    @ApiModelProperty(value = "Resultado Porcentagem")
    private double resultadoPorcentagem;


    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public double getResultadoPorcentagem() {
        return resultadoPorcentagem;
    }

    public void setResultadoPorcentagem(double resultadoPorcentagem) {
        this.resultadoPorcentagem = resultadoPorcentagem;
    }
}
