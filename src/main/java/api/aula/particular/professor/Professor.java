package api.aula.particular.professor;

import api.aula.particular.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Esta classe professor é uma entidade JPA (Java Persistence API)

@Table(name = "professores")
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
    private String telefone;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Professor(DadosCadastroProfessor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.disciplina = dados.disciplina();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(DadosAtualizaProfessor dados) {
        if(dados.nome()!= null) {
            this.nome = dados.nome();
        }
        if(dados.telefone()!=null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco()!=null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
