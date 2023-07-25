package api.aula.particular.professor;

import org.springframework.data.jpa.repository.JpaRepository;

//Nesta linha estamos criando uma interface que herda da JpaRepository
//Entre <Classe,Tipo Classe> colocamos a Entidade e o tipo do id
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}
