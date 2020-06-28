package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabalho.ces.trabalho.ces.backend.models.Usuario;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findById(long id);

    Usuario findFirstByEmailUsuario(String emailUsuario);

    Usuario findFirstByEmailUsuarioAndSenhaUsuario(String emailUsuario, String senhaUsuario);

    List<Usuario> findByTipoUsuarioidTipoUsuarioIdTipoUsuario(Integer idTipoUsuario);

    @Query("SELECT u FROM Usuario u \n" +
            "where u.idUsuario NOT IN (SELECT usuarioidUsuario FROM Resultado r where r.provaidProva.idProva =:idProva) \n" +
            "and u.tipoUsuarioidTipoUsuario.idTipoUsuario = 2 ")
    public List<Usuario> findByProvaPendente(@Param("idProva") Integer idProva);

}
