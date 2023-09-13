package api.aula.particular.domain.aula;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoAula(
        Long idProfessor,
        @NotNull
        Long idAluno,
        @Future //Anotação para garantir que seja uma data futura
        LocalDateTime data

) {
}
