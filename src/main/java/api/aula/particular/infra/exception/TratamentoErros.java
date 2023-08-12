package api.aula.particular.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class TratamentoErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){//Recebendo por parametro para retornar uma mensagem
        var erros = ex.getFieldErrors(); //Armazenando a lista de erros em cada um dos campos

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
    }

    private record DadosErrosValidacao(String campo, String mensagem){ //Criando o record interno para tratar cada campo que houve erro
        public DadosErrosValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    @RestControllerAdvice
    public class TratadorDeErros {

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity tratarErro404() {
            return ResponseEntity.notFound().build();
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
            var erros = ex.getFieldErrors();
            return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity tratarErro400(HttpMessageNotReadableException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        @ExceptionHandler(BadCredentialsException.class)
        public ResponseEntity tratarErroBadCredentials() {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        @ExceptionHandler(AuthenticationException.class)
        public ResponseEntity tratarErroAuthentication() {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
        }

        @ExceptionHandler(AccessDeniedException.class)
        public ResponseEntity tratarErroAcessoNegado() {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity tratarErro500(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " +ex.getLocalizedMessage());
        }

        private record DadosErroValidacao(String campo, String mensagem) {
            public DadosErroValidacao(FieldError erro) {
                this(erro.getField(), erro.getDefaultMessage());
            }
        }
    }

}
