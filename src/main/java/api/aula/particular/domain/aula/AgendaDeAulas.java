package api.aula.particular.domain.aula;

import api.aula.particular.domain.ValidacaoException;
import api.aula.particular.domain.aluno.AlunoRepository;
import api.aula.particular.domain.professor.Professor;
import api.aula.particular.domain.professor.ProfessorRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeAulas {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public void agendamento(DadosAgendamentoAula dados){

        if(!alunoRepository.existsById(dados.idAluno())){
            throw new ValidacaoException("O ID do aluno informado não existe!");
        }

        if(dados.idProfessor() !=null && !professorRepository.existsById(dados.idProfessor())){
            //verificando se esta solicitando um professor especifico e se esse professor existe
            throw new ValidacaoException("O ID do professor informado não existe!");
        }

        var professor = escolheProfessor(dados);
        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var aula = new Aula(null, professor, aluno, dados.data());

        aulaRepository.save(aula);
    }

    private Professor escolheProfessor(DadosAgendamentoAula dados) {
        if(dados.idProfessor()!=null){
            return professorRepository.getReferenceById(dados.idProfessor());
        }

        if(dados.disciplina() == null){
            throw new ValidacaoException("A disciplina é obrigatoria quando não houver um professor");
        }

        return professorRepository.escolherProfessorLivre(dados.disciplina(), dados.data());
    }

}
