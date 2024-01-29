package br.com.fiap.parquimetro.infraestructure.gateway.model;

import lombok.Data;

@Data
public class Pagador {

    private String cpfPagador;
    private String numeroCartao;
    private String nomeTitular;
    private String cvv;

}
