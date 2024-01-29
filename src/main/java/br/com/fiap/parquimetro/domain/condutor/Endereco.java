package br.com.fiap.parquimetro.domain.condutor;

import lombok.Data;

@Data
public class Endereco {

    private String uuid;

    private String rua;

    private Integer numero;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    String getEnderecoComleto() {
        return String.format("%s, %d, %s, %s - %s, %s",
                this.rua,
                this.numero,
                this.bairro,
                this.cidade,
                this.uf);
    }

}
