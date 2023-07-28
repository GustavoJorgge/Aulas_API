package api.aula.particular.controller;

import api.aula.particular.aluno.*;
import jakarta.transaction.TransactionScoped;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<DadosListagemAluno> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

}
