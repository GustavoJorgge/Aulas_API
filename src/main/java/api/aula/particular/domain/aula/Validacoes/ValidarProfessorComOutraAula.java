package api.aula.particular.domain.aula.Validacoes;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aula.AulaRepository;
import api.aula.particular.domain.aula.DadosAgendamentoAula;

public class ValidarProfessorComOutraAula {

    private AulaRepository repository;

    public void validar(DadosAgendamentoAula dados){
        var professorPossuiConsultaNoHorario = repository.existsByProfessorIdAndData(dados.idProfessor(), dados.data());

        if(professorPossuiConsultaNoHorario){
            throw new ValidacaoException("Este professor ja possui outra aula agendada no mesmo horario!");
        }
    }
}
