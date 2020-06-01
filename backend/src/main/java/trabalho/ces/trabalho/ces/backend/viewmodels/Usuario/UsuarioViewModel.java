package trabalho.ces.trabalho.ces.backend.viewmodels.Usuario;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioViewModel {
    @ApiModelProperty(value = "Id do usuário")
    private long idUsuario;

    @ApiModelProperty(value = "Nome do usuário")
    private String nomeUsuario;

    @ApiModelProperty(value = "E-mail do usuário")
    private String emailUsuario;

    @ApiModelProperty(value = "Senha do usuário")
    private String senhaUsuario;

    @ApiModelProperty(value = "Id tipo do usuário")
    private int idTipoUsuario;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
