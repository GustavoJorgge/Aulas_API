package api.aula.particular.domain.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao); //Query para listar os alunos que estao ativos

    @Query("""
            select p.ativo
            from alunos p
            where 
            p.id = :id
            """)
    Boolean findAtivoById(Long idAluno);
}
