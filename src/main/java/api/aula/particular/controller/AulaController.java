package api.aula.particular.controller;

import api.aula.particular.domain.aula.AgendaDeAulas;
import api.aula.particular.domain.aula.DadosAgendamentoAula;
import api.aula.particular.domain.aula.DadosDetalhamentoAula;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aulas")
public class AulaController {

    @Autowired
    private AgendaDeAulas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAula dados){

        agenda.agendamento(dados);//forma correta de chamar a classe com regras de negocio - Não deve-se incluir regras no controller


        return ResponseEntity.ok(new DadosDetalhamentoAula(null,null,null,null));
    }
}
