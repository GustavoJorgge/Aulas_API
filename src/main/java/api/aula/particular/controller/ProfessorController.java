package api.aula.particular.controller;

import api.aula.particular.professor.DadosCadastroProfessor;
import api.aula.particular.professor.Professor;
import api.aula.particular.professor.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping //Quando chegar uma requisição do tipo Post, ira chamar este metodo
    @Transactional // Anotação para transações
    public void cadastrar(@RequestBody @Valid DadosCadastroProfessor dados){ //Anotação para receber o corpo da requisição
       repository.save(new Professor(dados));
    }

}
