package api.aula.particular.professor;

import api.aula.particular.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @Pattern(regexp = "\\d{11}") //Expressão regular para cpf (deve ser 11 digitos)
        String cpf,
        @NotNull
        Disciplina disciplina,
        @NotNull @Valid
        DadosEndereco endereco) {
}
