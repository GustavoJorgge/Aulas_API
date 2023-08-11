package api.aula.particular.infra.security;

import api.aula.particular.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") //Anotação para buscar da classe Application.properties
    private String secret; //Estamos armazendo nesta variavel pois não é boa pratica armazenar senhas no codigo

    public String geraToken(Usuario usuario){

        System.out.println(secret);

        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API aula.particular")// Define o emissor do token. (nome da API)
                    .withSubject(usuario.getLogin()) // Define o assunto (subject) do token como o login do usuário.
                    .withExpiresAt(expiraEm()) // Define o tempo de expiração do token.
                    .sign(algoritmo); // Assina o token com o algoritmo escolhido e a chave secreta.
        } catch (JWTCreationException exception){
          throw new RuntimeException("erro ao gerar token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            /*
            Este retorno eu busquei na documentação da JWT
            Serve para validar se o token recebido é valido
             */
            return JWT.require(algoritmo)
                    .withIssuer("API aula.particular")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant expiraEm() {
        /* Obtém a data e hora atual.
           Adiciona 2 horas à data e hora atual.
           Converte a data e hora futuras para um instante de tempo, considerando um deslocamento de fuso horário de -03:00.
         */
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
