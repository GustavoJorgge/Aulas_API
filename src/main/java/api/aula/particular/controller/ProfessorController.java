package api.aula.particular.controller;

import api.aula.particular.professor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping //Quando chegar uma requisição do tipo Post, ira chamar este metodo
    @Transactional // Anotação para transações
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder){ //Anotação para receber o corpo da requisição e
       var professor = new Professor(dados); //variavel para guardar os dados
        repository.save(professor);// Salvando no banco

       var uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();

       return  ResponseEntity.created(uri).body(new DadosDetalhesProf(professor)); // Retornando codigo HTTP 201
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemProfessor>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new); //.stream().mal() converte de professor para Record e retornando em lista
         return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaProfessor dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhesProf(professor));
    }

    @DeleteMapping("/{id}") //parametro dinamico
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluir();

        return ResponseEntity.noContent().build();
    }

}
