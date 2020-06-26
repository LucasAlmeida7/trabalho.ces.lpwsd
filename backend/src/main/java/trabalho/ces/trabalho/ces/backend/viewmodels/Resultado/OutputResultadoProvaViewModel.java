package trabalho.ces.trabalho.ces.backend.viewmodels.Resultado;

import io.swagger.annotations.ApiModelProperty;

public class OutputResultadoProvaViewModel {
    @ApiModelProperty(value = "Número de Alunos Concluídos")
    private double concluido;

    @ApiModelProperty(value = "Número de Alunos Pendentes")
    private double pendente;


    public double getConcluido() {
        return concluido;
    }

    public void setConcluido(double concluido) {
        this.concluido = concluido;
    }

    public double getPendente() {
        return pendente;
    }

    public void setPendente(int pendente) {
        this.pendente = pendente;
    }
}
