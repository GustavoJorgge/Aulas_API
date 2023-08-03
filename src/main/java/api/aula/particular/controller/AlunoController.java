package api.aula.particular.controller;

import api.aula.particular.aluno.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid  DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);

        /*
        uriBuilder.path("/alunos/{id}"): Aqui, é criado um construtor de URI (uriBuilder) com o caminho base "/alunos/{id}", onde "{id}" é um espaço reservado para ser preenchido posteriormente com um valor numérico.
        buildAndExpand(aluno.getId()): O método buildAndExpand() é utilizado para preencher o espaço reservado "{id}" com o ID do aluno fornecido pelo objeto aluno. Ele substitui "{id}" pelo valor correspondente ao ID do aluno no caminho da URI.
        toUri(): O método toUri() é chamado para finalizar a construção da URI e retorná-la como resultado. A URI completa será usada para acessar a representação específica do aluno identificado pelo ID fornecido.
         */
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhesAluno(aluno)); //Retornando codigo 201
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhesAluno(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhesAluno(aluno));
    }

}
