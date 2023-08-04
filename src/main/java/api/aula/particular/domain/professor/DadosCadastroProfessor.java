package api.aula.particular.domain.professor;

import api.aula.particular.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(

        @NotBlank
        String nome,
        @NotBlank(message = "O E-mail é obrigatorio!")
        @Email(message = "Formato invalido!")
        String email,

        @NotBlank (message = "O Telefone é obrigatorio!")
        String telefone,
        @NotBlank(message = "O CPF é Obrigatorio")
        @Pattern(regexp = "\\d{11}", message = "Formato de CPF invalido!") //Expressão regular para cpf (deve ser 11 digitos)
        String cpf,
        @NotNull (message = "Disciplina é obrigatoria!")
        Disciplina disciplina,
        @NotNull(message = "O endereço é obrigatorio!")
        @Valid
        DadosEndereco endereco) {
}
