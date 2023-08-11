package api.aula.particular.infra.security;

import api.aula.particular.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService; //deve ser o Token Service do projeto e NÃO o do Spring

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToket(request); //chamando metodo para recuperar o Token

        if(tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT); //Armazenando a validação do Token
            var usuarioLogado = repository.findByLogin(subject); // Buscando o usuairo logado

            var authentication = new UsernamePasswordAuthenticationToken(usuarioLogado, null, usuarioLogado.getAuthorities());//Armazenando o usuario na variavel
            SecurityContextHolder.getContext().setAuthentication(authentication);//Forçando authenticação
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToket(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader!= null){
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;


    }
}
