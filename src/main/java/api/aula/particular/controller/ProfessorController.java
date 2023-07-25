package api.aula.particular.controller;

import api.aula.particular.professor.DadosCadastroProfessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    @PostMapping //Quando chegar uma requisição do tipo Post, ira chamar este metodo
    public void cadastrar(@RequestBody DadosCadastroProfessor dados){ //Anotação para receber o corpo da requisição
        System.out.println(dados);//testando recebimento
    }

}
