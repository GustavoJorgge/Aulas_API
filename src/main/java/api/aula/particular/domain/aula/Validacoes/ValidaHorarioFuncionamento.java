package api.aula.particular.domain.aula.Validacoes;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aula.DadosAgendamentoAula;

import java.time.DayOfWeek;

public class ValidaHorarioFuncionamento {

    public void validar(DadosAgendamentoAula dados){
        var dataAula = dados.data();

        var domingo = dataAula.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var AntesAbertura = dataAula.getHour() < 7;
        var DepoisEncerramento = dataAula.getHour() > 18;

        if(domingo || AntesAbertura || DepoisEncerramento){
            throw new ValidacaoException("Agendamento fora do horario de funcionamento");
        }


    }
}
