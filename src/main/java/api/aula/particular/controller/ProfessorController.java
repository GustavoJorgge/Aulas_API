package api.aula.particular.controller;

import api.aula.particular.professor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DadosListagemProfessor> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new); //.stream().mal() converte de professor para Record e retornando em lista
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaProfessor dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarDados(dados);
    }

    @DeleteMapping("/{id}") //parametro dinamico
    @Transactional
    public void deletar(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluir();
    }

}
