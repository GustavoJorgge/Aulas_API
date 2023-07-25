package api.aula.particular.professor;

import api.aula.particular.endereco.DadosEndereco;

public record DadosCadastroProfessor(String nome, String email, int cpf, Disciplina disciplina, DadosEndereco endereco) {
}
