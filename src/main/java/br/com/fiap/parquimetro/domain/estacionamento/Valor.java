package br.com.fiap.parquimetro.domain.estacionamento;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Valor {

    private final BigDecimal TAXA = BigDecimal.valueOf(1.5);
    private BigDecimal valor;

    public Valor(){

    }

    public Valor(BigDecimal valor) {
        this.valor = valor;
    }

    void calculaCobranca(long tempo) {
        this.valor = TAXA.multiply(
                BigDecimal.valueOf(tempo));
    }

}
