package br.com.fiap.parquimetro.domain.estacionamento;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Pagamento {

    private String uuid;
    private BigDecimal valor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataPagamento;
    private FormaPagamentoEnum formaPagamento;
    private StatusPagamentoEnum statusPagamento;
    private Cartao cartao;

}
