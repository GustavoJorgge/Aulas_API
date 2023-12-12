package api.aula.particular.domain.professor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

//Nesta linha estamos criando uma interface que herda da JpaRepository
//Entre <Classe,Tipo Classe> colocamos a Entidade e o tipo do id
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    Page<Professor> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select prof from professores prof
            where 
            prof.ativo = 1
            and
            prof.disciplina = :disciplina
            and
            prof.id not in (select a.professor.id from aulas a where a.data = :data)
            order by rand()
            limit 1
            """)
    Professor escolherProfessorLivre(Disciplina disciplina, LocalDateTime data);

    @Query("""
            select p.ativo
            from professores p
            where 
            p.id = :id
            """)
    Boolean findAtivoById(Long idProfessor);
}
