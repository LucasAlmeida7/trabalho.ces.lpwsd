package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.ces.trabalho.ces.backend.models.TipoQuestao;

public interface ITipoQuestaoRepository extends JpaRepository<TipoQuestao, Long> {
    TipoQuestao findById(long id);
}