package trabalho.ces.trabalho.ces.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbProva")
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id da prova")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProva")
    private Integer idProva;

    @ApiModelProperty(value = "Data da prova")
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataProva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProva;

    @JsonIgnore
    @JoinTable(name = "tbProva_has_tbQuestao", joinColumns = {
            @JoinColumn(name = "tbProva_idProva", referencedColumnName = "idProva")}, inverseJoinColumns = {
            @JoinColumn(name = "tbQuestao_idQuestao", referencedColumnName = "idQuestao")})
    @ManyToMany
    private List<Questao> questaoList;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provaidProva")
    private List<Resultado> resultadoList;

    public Prova() {
    }

    public Prova(Integer idProva) {
        this.idProva = idProva;
    }

    public Prova(Integer idProva, Date dataProva) {
        this.idProva = idProva;
        this.dataProva = dataProva;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    @XmlTransient
    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }
}
