package api.aula.particular.professor;

import api.aula.particular.endereco.DadosEndereco;

public record DadosCadastroProfessor(String nome, String email, Integer cpf, Disciplina disciplina, DadosEndereco endereco) {
}
