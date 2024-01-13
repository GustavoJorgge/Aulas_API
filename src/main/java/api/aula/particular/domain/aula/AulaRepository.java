package api.aula.particular.domain.aula;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AulaRepository extends JpaRepository<Aula, Long> {

    boolean existsByAlunoIdAndDataBetween(Long idAluno, LocalDateTime data);

    boolean existsByProfessorIdAndData(Long idProfessor, LocalDateTime data);
}
