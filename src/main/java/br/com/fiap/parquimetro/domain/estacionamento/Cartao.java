package br.com.fiap.parquimetro.domain.estacionamento;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Cartao {

    private String uuid;
    private String numeroCartao;
    private String nomeTitular;
    private String cvv;

}
