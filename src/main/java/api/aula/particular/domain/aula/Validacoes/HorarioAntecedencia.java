package api.aula.particular.domain.aula.Validacoes;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aula.DadosAgendamentoAula;

import java.time.Duration;
import java.time.LocalDateTime;

public class HorarioAntecedencia {

    public void validar(DadosAgendamentoAula dados){

        var dataAula = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataAula).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("As aulas devem ser agendadas com antecedencia minima de 30 minutos");
        }

    }


}
