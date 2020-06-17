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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuestao")
    private Long idQuestao;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;

    @Size(max = 45)
    @Column(name = "alternativaA")
    private String alternativaA;

    @Size(max = 45)
    @Column(name = "alternativaB")
    private String alternativaB;

    @Size(max = 45)
    @Column(name = "alternativaC")
    private String alternativaC;

    @Size(max = 45)
    @Column(name = "alternativaD")
    private String alternativaD;

    @Size(max = 45)
    @Column(name = "alternativaE")
    private String alternativaE;

    @Column(name = "alternativaCorreta")
    private Character alternativaCorreta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoQuestao")
    private short estadoQuestao;

    @ManyToMany(mappedBy = "questaoList")
    private List<Prova> provaList;

    @JoinColumn(name = "tbTipoQuestao_idTipoQuestao", referencedColumnName = "idTipoQuestao")
    @ManyToOne(optional = false)
    private TipoQuestao tipoQuestaoidTipoQuestao;

    public Questao() {
    }

    public Questao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Questao(Long idQuestao, String descricaoQuestao, short estadoQuestao) {
        this.idQuestao = idQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.estadoQuestao = estadoQuestao;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Long idQuestao) {
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

    public String descricaoEstado()
    {
        return this.getEstadoQuestao() == 1 ? "Ativada" : "Desativada";
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
