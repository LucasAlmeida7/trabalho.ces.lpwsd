package trabalho.ces.trabalho.ces.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.ces.trabalho.ces.backend.models.Questao;

import java.util.List;

public interface IQuestaoRepository extends JpaRepository<Questao, Long> {
    Questao findById(long id);

    List<Questao> findAllByEstadoQuestao(short estadoQuestao);
}
