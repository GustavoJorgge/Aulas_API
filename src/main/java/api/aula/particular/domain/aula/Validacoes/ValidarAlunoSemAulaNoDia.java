package api.aula.particular.domain.aula.Validacoes;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aula.AulaRepository;
import api.aula.particular.domain.aula.DadosAgendamentoAula;

public class ValidarAlunoSemAulaNoDia {

    private AulaRepository repository;

    public void validar(DadosAgendamentoAula dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var AlunoPossuiOutraAulaNoDia = repository.existsByAlunoIdAndDataBetween(dados.idAluno(), dados.data());

        if(AlunoPossuiOutraAulaNoDia)
        {
            throw new ValidacaoException("Aluno ja possui aula agendada no Dia!");
        }
    }
}
