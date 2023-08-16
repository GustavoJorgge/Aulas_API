package api.aula.particular.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Anotação para API's REST
@RequestMapping ("/hello") //mapeando a requisição
public class AplicacaoController {

    //trabalhando na nova branch
    //rebase1

    @GetMapping
    public String teste(){
        return "Testando Requisição!";
    }
     // Final da aplicacao
}
