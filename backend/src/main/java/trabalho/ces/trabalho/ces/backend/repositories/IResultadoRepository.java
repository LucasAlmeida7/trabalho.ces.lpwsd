package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.ces.trabalho.ces.backend.models.Resultado;

import java.util.List;

public interface IResultadoRepository extends JpaRepository<Resultado, Integer> {
    List<Resultado> findTop10ByOrderByIdResultadoDesc();
    List<Resultado> findByProvaidProvaIdProva(Integer idProva);
}
