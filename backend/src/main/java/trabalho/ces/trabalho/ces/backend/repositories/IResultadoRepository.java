package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabalho.ces.trabalho.ces.backend.models.Resultado;
import trabalho.ces.trabalho.ces.backend.models.Usuario;

import java.util.List;

public interface IResultadoRepository extends JpaRepository<Resultado, Integer> {
    List<Resultado> findByProvaidProvaIdProva(Integer idProva);
    List<Resultado> findTop10ByProvaidProvaIdProvaOrderByIdResultadoDesc(Integer idProva);
}
