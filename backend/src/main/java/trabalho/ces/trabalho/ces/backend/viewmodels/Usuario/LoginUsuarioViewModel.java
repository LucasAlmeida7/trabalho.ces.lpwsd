package trabalho.ces.trabalho.ces.backend.viewmodels.Usuario;

import io.swagger.annotations.ApiModelProperty;

public class LoginUsuarioViewModel {

    @ApiModelProperty(value = "E-mail do usuário", example = "usuário", required = true)
    private String emailUsuario;

    @ApiModelProperty(value = "Senha do usuário", example = "usuário", required = true)
    private String senhaUsuario;

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
}