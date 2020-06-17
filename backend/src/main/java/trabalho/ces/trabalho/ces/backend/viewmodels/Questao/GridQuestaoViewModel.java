package trabalho.ces.trabalho.ces.backend.viewmodels.Questao;

import io.swagger.annotations.ApiModelProperty;

public class GridQuestaoViewModel {

    @ApiModelProperty(value = "Id da questão")
    private Integer idQuestao;

    @ApiModelProperty(value = "Descrição da questão")
    private String descricaoQuestao;

    @ApiModelProperty(value = "Alternativa A da questão")
    private String alternativaA;

    @ApiModelProperty(value = "Alternativa B da questão")
    private String alternativaB;

    @ApiModelProperty(value = "Alternativa C da questão")
    private String alternativaC;

    @ApiModelProperty(value = "Alternativa D da questão")
    private String alternativaD;

    @ApiModelProperty(value = "Alternativa E da questão")
    private String alternativaE;

    @ApiModelProperty(value = "Alternativa correta da questão")
    private Character alternativaCorreta;

    @ApiModelProperty(value = "Estado da questão")
    private String estadoQuestao;

    @ApiModelProperty(value = "Nome tipo da questão")
    private String nomeTipoQuestao;


    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public Character getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(Character alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(String estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String idTipoQuestao) {
        this.nomeTipoQuestao = idTipoQuestao;
    }

}
