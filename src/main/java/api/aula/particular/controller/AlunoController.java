package api.aula.particular.controller;

import api.aula.particular.aluno.Aluno;
import api.aula.particular.aluno.AlunoRepository;
import api.aula.particular.aluno.DadosCadastroAluno;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid  DadosCadastroAluno dados){
        repository.save(new Aluno(dados));
    }

}
