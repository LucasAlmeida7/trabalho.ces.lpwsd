package trabalho.ces.trabalho.ces.backend.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tbTipoQuestao")
public class TipoQuestao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoQuestao")
    private Long idTipoQuestao;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTipoQuestao")
    private String nomeTipoQuestao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoQuestaoidTipoQuestao")
    private List<Questao> questaoList;

    public TipoQuestao() {
    }

    public TipoQuestao(Long idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public TipoQuestao(Long idTipoQuestao, String nomeTipoQuestaocol) {
        this.idTipoQuestao = idTipoQuestao;
        this.nomeTipoQuestao = nomeTipoQuestaocol;
    }

    public Long getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Long idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String nomeTipoQuestaocol) {
        this.nomeTipoQuestao = nomeTipoQuestaocol;
    }

    @XmlTransient
    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoQuestao != null ? idTipoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoQuestao)) {
            return false;
        }
        TipoQuestao other = (TipoQuestao) object;
        if ((this.idTipoQuestao == null && other.idTipoQuestao != null) || (this.idTipoQuestao != null && !this.idTipoQuestao.equals(other.idTipoQuestao))) {
            return false;
        }
        return true;
    }
}