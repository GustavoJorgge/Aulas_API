package api.aula.particular.domain.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao); //Query para listar os alunos que estao ativos
}
