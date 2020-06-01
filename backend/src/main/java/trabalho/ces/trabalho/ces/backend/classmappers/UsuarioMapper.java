package trabalho.ces.trabalho.ces.backend.classmappers;

import trabalho.ces.trabalho.ces.backend.models.TipoUsuario;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InserirUsuarioViewModel;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.UsuarioViewModel;

public class UsuarioMapper {

    public Usuario ToNewModel(InserirUsuarioViewModel inserirUsuarioViewModel){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(inserirUsuarioViewModel.getNomeUsuario());
        usuario.setEmailUsuario(inserirUsuarioViewModel.getEmailUsuario());
        usuario.setSenhaUsuario(inserirUsuarioViewModel.getSenhaUsuario());
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(inserirUsuarioViewModel.getIdTipoUsuario());
        usuario.setTipoUsuarioidTipoUsuario(tipoUsuario);
        return usuario;
    }

    public Usuario ToModel(Usuario usuario, UsuarioViewModel usuarioViewModel){
        usuario.setIdUsuario(usuarioViewModel.getIdUsuario());
        usuario.setNomeUsuario(usuarioViewModel.getNomeUsuario());
        usuario.setEmailUsuario(usuarioViewModel.getEmailUsuario());
        usuario.setSenhaUsuario(usuarioViewModel.getSenhaUsuario());
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(usuarioViewModel.getIdTipoUsuario());
        usuario.setTipoUsuarioidTipoUsuario(tipoUsuario);
        return usuario;
    }
}
