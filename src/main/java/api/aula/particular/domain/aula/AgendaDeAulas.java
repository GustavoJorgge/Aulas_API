package api.aula.particular.domain.aula;

import api.aula.particular.domain.aluno.AlunoRepository;
import api.aula.particular.domain.professor.ProfessorRepository;
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

        var professor = professorRepository.findById(dados.idProfessor()).get();
        var aluno = alunoRepository.findById(dados.idAluno()).get();
        var aula = new Aula(null, professor, aluno, dados.data());

        aulaRepository.save(aula);
    }

}
