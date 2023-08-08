package api.aula.particular.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Classe de configuração
@EnableWebSecurity //Personalização de configuração de segurança
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable() //Desabilitando o ataque
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().build(); //desabilitando o formulario padrao do Spring e desbloqueando as urls para personalizar a configuração
    }


}
