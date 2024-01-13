package api.aula.particular.domain.aula.Validacoes;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aluno.AlunoRepository;
import api.aula.particular.domain.aula.DadosAgendamentoAula;

public class ValidarAlunoAtivo {

    private AlunoRepository repository;

    public void validar(DadosAgendamentoAula dados){
        if(dados.idAluno() == null){
            return;
        }

        var alunoAtivo = repository.findAtivoById(dados.idAluno());
        if(!alunoAtivo){
            throw new ValidacaoException("A aula não pode ser agendada com usuarios inativos!");
        }
    }
}
