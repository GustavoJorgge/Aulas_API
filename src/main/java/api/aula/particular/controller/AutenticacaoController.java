package api.aula.particular.controller;

import api.aula.particular.domain.usuario.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager; //Classe que dispara o processo de Autenticação

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DadosAutenticacao dados){

        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha()); //classe para receber dados de login
        var authentication = manager.authenticate(token); // convertendo dto e armazenando o objeto do usuario authenticado no sistema

        return ResponseEntity.ok().build();
    }

}
