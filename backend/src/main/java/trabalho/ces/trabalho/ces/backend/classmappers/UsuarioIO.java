package trabalho.ces.trabalho.ces.backend.classmappers;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;
import trabalho.ces.trabalho.ces.backend.models.TipoUsuario;
import trabalho.ces.trabalho.ces.backend.models.Usuario;
import trabalho.ces.trabalho.ces.backend.viewmodels.Usuario.InputUsuarioViewModel;

@Component("usuarioIO")
public class UsuarioIO {

    private ModelMapper modelMapper;

    final Converter<InputUsuarioViewModel, Usuario> usuarioConverter
            = new Converter<InputUsuarioViewModel, Usuario>() {

        @Override
        public Usuario convert(MappingContext<InputUsuarioViewModel, Usuario> context) {

            InputUsuarioViewModel inputUsuarioViewModel = context.getSource();

            Usuario usuario = new Usuario();
            usuario.setNomeUsuario(inputUsuarioViewModel.getNomeUsuario());
            usuario.setEmailUsuario(inputUsuarioViewModel.getEmailUsuario());
            usuario.setSenhaUsuario(inputUsuarioViewModel.getSenhaUsuario());
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdTipoUsuario(inputUsuarioViewModel.getIdTipoUsuario());
            usuario.setTipoUsuarioidTipoUsuario(tipoUsuario);

            return usuario;
        }
    };

    public UsuarioIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(usuarioConverter);
    }

    public Usuario mapTo(InputUsuarioViewModel inputUsuarioViewModel) {
        return this.modelMapper.map(inputUsuarioViewModel, Usuario.class);
    }
}