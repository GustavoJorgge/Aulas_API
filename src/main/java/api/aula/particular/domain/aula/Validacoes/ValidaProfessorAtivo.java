package api.aula.particular.domain.aula.Validacoes;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aula.DadosAgendamentoAula;
import api.aula.particular.domain.professor.ProfessorRepository;

public class ValidaProfessorAtivo {

    private ProfessorRepository repository;

    public void validar(DadosAgendamentoAula dados){
        //Escolha do professor é opcional
        if(dados.idProfessor() == null){
            return;
        }

        var professorAtivo = repository.findAtivoById(dados.idProfessor());
        if(!professorAtivo){
            throw new ValidacaoException("As aulas nao podem ser agendadas com professores inativos");
        }
    }

}
