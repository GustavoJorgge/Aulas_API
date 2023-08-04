package api.aula.particular.domain.aluno;

import api.aula.particular.domain.endereco.Endereco;

public record DadosDetalhesAluno(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhesAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getTelefone(), aluno.getEndereco());
    }

}
