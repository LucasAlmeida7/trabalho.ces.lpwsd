package trabalho.ces.trabalho.ces.backend.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id do usuário")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(value = "Nome do usuário")
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
