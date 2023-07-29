package api.aula.particular.aluno;

import api.aula.particular.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of= "id")
public class Aluno {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Aluno(DadosCadastroAluno dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(DadosAtualizaAluno dados) {

        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
        if(dados.email()!=null){
            this.nome = dados.email();
        }
        if(dados.cpf()!=null){
            this.nome = dados.cpf();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
