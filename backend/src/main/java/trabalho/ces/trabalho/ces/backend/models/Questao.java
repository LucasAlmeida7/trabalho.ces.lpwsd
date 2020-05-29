package trabalho.ces.trabalho.ces.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tbQuestao")
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id da questão")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuestao")
    private Integer idQuestao;

    @ApiModelProperty(value = "Descrição da questão")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;

    @ApiModelProperty(value = "Alternativa A da questão")
    @Size(max = 45)
    @Column(name = "alternativaA")
    private String alternativaA;

    @ApiModelProperty(value = "Alternativa B da questão")
    @Size(max = 45)
    @Column(name = "alternativaB")
    private String alternativaB;

    @ApiModelProperty(value = "Alternativa C da questão")
    @Size(max = 45)
    @Column(name = "alternativaC")
    private String alternativaC;

    @ApiModelProperty(value = "Alternativa D da questão")
    @Size(max = 45)
    @Column(name = "alternativaD")
    private String alternativaD;

    @ApiModelProperty(value = "Alternativa E da questão")
    @Size(max = 45)
    @Column(name = "alternativaE")
    private String alternativaE;

    @ApiModelProperty(value = "Alternativa correta da questão")
    @Column(name = "alternativaCorreta")
    private Character alternativaCorreta;

    @ApiModelProperty(value = "Estado da questão")
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoQuestao")
    private short estadoQuestao;

    @JsonIgnore
    @ManyToMany(mappedBy = "questaoList")
    private List<Prova> provaList;

    @ApiModelProperty(value = "Tipo da questão")
    @JoinColumn(name = "tbTipoQuestao_idTipoQuestao", referencedColumnName = "idTipoQuestao")
    @ManyToOne(optional = false)
    private TipoQuestao tipoQuestaoidTipoQuestao;

    public Questao() {
    }

    public Questao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Questao(Integer idQuestao, String descricaoQuestao, short estadoQuestao) {
        this.idQuestao = idQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.estadoQuestao = estadoQuestao;
    }

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

    public short getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(short estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    @XmlTransient
    public List<Prova> getProvaList() {
        return provaList;
    }

    public void setProvaList(List<Prova> provaList) {
        this.provaList = provaList;
    }

    public TipoQuestao getTipoQuestaoidTipoQuestao() {
        return tipoQuestaoidTipoQuestao;
    }

    public void setTipoQuestaoidTipoQuestao(TipoQuestao tipoQuestaoidTipoQuestao) {
        this.tipoQuestaoidTipoQuestao = tipoQuestaoidTipoQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }
}
