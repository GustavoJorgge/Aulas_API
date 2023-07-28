package api.aula.particular.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaAluno(
        @NotNull
        Long id,
        String nome,
        String email,
        String cpf) {
}
