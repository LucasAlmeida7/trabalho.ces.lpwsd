package trabalho.ces.trabalho.ces.backend.viewmodels.Relatorio;

import io.swagger.annotations.ApiModelProperty;

public class OutputRelatorioResultadoViewModel {

    @ApiModelProperty(value = "Nome do usuário")
    private String nomeUsuario;

    @ApiModelProperty(value = "Valor Obtido")
    private double valorObtido;

    @ApiModelProperty(value = "Número de Questões")
    private int NumeroQuestoes;


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }

    public int getNumeroQuestoes() {
        return NumeroQuestoes;
    }

    public void setNumeroQuestoes(int numeroQuestoes) {
        NumeroQuestoes = numeroQuestoes;
    }
}
