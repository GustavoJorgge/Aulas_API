package api.aula.particular.domain.professor;

import api.aula.particular.domain.endereco.Endereco;

public record DadosDetalhesProf(Long id, String nome, String email, String telefone, String cpf, Disciplina disciplina, Endereco endereco) {

    public DadosDetalhesProf(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getTelefone(), professor.getCpf(), professor.getDisciplina(), professor.getEndereco());
    }
}
