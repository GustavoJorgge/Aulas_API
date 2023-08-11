package api.aula.particular.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //Classe de configuração
@EnableWebSecurity //Personalização de configuração de segurança
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter; //chamando o filtro para configurar a ordem

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable() //Desabilitando o ataque
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST,"/login").permitAll() //Liberando acesso para qualquer um
                .anyRequest().authenticated() //Bloqueando acesso para usuarios nao logados
                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //configurando ordem de filtro
                .build(); //desabilitando o formulario padrao do Spring e desbloqueando as urls para personalizar a configuração
    }

    @Bean //Serve para exportar uma classe para o Spring, fazendo com que ele consiga carrega-la e realize sua injeção de dependecia em outras classes
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();//Cria objeto do tipo AuthenticationManager
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
