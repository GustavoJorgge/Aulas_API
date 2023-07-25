package api.aula.particular.professor;

import api.aula.particular.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Esta classe professor é uma entidade JPA (Java Persistence API)

@Table(name = "professor")
@Entity (name = "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of= "id")
public class Professor {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Integer cpf;
    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;
    @Embedded
    private Endereco endereco;

}
