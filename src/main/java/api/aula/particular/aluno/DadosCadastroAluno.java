package api.aula.particular.aluno;

import api.aula.particular.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull @Valid
        DadosEndereco endereco
) {
}
