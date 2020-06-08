package trabalho.ces.trabalho.ces.backend.viewmodels.Usuario;

import io.swagger.annotations.ApiModelProperty;

public class InputUsuarioViewModel {

    @ApiModelProperty(value = "Nome do usuário", example = "usuário", required = true)
    private String nomeUsuario;

    @ApiModelProperty(value = "E-mail do usuário", example = "usuario@usuario.com", required = true)
    private String emailUsuario;

    @ApiModelProperty(value = "Senha do usuário", example = "senhaUsuario", required = true)
    private String senhaUsuario;

    @ApiModelProperty(value = "Id tipo do usuário", example = "1", required = true)
    private int idTipoUsuario;


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
