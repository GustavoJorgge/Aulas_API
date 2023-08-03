package api.aula.particular.aluno;

import api.aula.particular.aluno.Aluno;
import api.aula.particular.endereco.Endereco;
import api.aula.particular.professor.DadosDetalhesProf;

public record DadosDetalhesAluno(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhesAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getTelefone(), aluno.getEndereco());
    }

}
