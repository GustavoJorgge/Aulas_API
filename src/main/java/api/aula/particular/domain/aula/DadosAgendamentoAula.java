package api.aula.particular.domain.aula;

import api.aula.particular.domain.professor.Disciplina;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoAula(
        Long idProfessor,
        @NotNull
        Long idAluno,

        @NotNull
        @Future //Anotação para garantir que seja uma data futura
        LocalDateTime data,

        Disciplina disciplina

) {
}
