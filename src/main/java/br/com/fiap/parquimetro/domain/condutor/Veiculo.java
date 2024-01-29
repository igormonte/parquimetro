package br.com.fiap.parquimetro.domain.condutor;

import lombok.Data;

@Data
public class Veiculo {

    String uuid;
    String placa;
    String nome;
    Boolean inativo;

    public Veiculo() {}

}
