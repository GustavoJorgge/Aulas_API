package api.aula.particular.professor;

import api.aula.particular.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaProfessor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
