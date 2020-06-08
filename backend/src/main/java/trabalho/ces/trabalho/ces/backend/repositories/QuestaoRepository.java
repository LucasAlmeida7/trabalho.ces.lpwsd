package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.ces.trabalho.ces.backend.models.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    Questao findById(long id);

}
