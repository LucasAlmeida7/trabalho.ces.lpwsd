package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.ces.trabalho.ces.backend.models.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findById(long id);

    Usuario findFirstByEmailUsuarioAndSenhaUsuario(String emailUsuario, String senhaUsuario);
}
