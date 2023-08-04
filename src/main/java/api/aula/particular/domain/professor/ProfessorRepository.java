package api.aula.particular.domain.professor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Nesta linha estamos criando uma interface que herda da JpaRepository
//Entre <Classe,Tipo Classe> colocamos a Entidade e o tipo do id
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    Page<Professor> findAllByAtivoTrue(Pageable paginacao);
}
