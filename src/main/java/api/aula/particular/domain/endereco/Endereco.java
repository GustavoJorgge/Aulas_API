package api.aula.particular.domain.endereco;
// Esta é uma classe entidade JPA

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.logradouro()!= null){
            this.logradouro = endereco.logradouro();
        }
        if(endereco.bairro()!=null){
            this.bairro = endereco.bairro();
        }
        if(endereco.cep()!= null){
            this.cep = endereco.cep();
        }
        if(endereco.numero()!=null){
            this.numero = endereco.numero();
        }
        if(endereco.complemento()!= null){
            this.cep = endereco.complemento();
        }
        if(endereco.cidade()!= null){
            this.cidade = endereco.cidade();
        }
        if(endereco.uf()!= null){
            this.uf = endereco.uf();
        }
    }
}
