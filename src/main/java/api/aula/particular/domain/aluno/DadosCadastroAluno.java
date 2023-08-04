package api.aula.particular.domain.aluno;

import api.aula.particular.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

        @NotBlank (message = "O nome é obrigatorio!")
        String nome,
        @NotBlank (message = "O E-mail é obrigatorio!")
        @Email (message = "Formato de E-mail invalido!")
        String email,

        @NotBlank (message = "O telefone é obrigatorio!")
        String telefone,

        @NotBlank(message = "O CPF é obrigatorio!")
        @Pattern(regexp = "\\d{11}", message = "Formato de CPF invalido")
        String cpf,

        @NotNull (message = "O endereço é obrigatorio")
        @Valid
        DadosEndereco endereco
) {
}
