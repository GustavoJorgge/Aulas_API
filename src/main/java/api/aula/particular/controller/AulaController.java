package api.aula.particular.controller;

import api.aula.particular.domain.aula.DadosAgendamentoAula;
import api.aula.particular.domain.aula.DadosDetalhamentoAula;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aulas")
public class AulaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAula dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAula(null,null,null,null));
    }
}
