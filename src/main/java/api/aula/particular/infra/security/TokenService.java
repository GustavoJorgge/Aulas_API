package api.aula.particular.infra.security;

import api.aula.particular.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String geraToken(Usuario usuario){

        try {
            var algoritmo = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("API aula.particular")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(expiraEm())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
          throw new RuntimeException("erro ao gerar token JWT", exception);
        }
    }

    private Instant expiraEm() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
