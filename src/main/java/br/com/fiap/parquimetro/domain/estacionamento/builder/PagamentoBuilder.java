package br.com.fiap.parquimetro.domain.estacionamento.builder;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Cartao;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.StatusPagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoBuilder extends Pagamento {

    public PagamentoBuilder(){}

    public PagamentoBuilder withUuid(String uuid) {
        this.setUuid(uuid);
        return this;
    }

    public PagamentoBuilder withValor(BigDecimal valor) {
        this.setValor(valor);
        return this;
    }

    public PagamentoBuilder withDataCriacao(LocalDateTime dataCriacao) {
        this.setDataCriacao(dataCriacao);
        return this;
    }

    public PagamentoBuilder withDataPagamento(LocalDateTime dataPagamento) {
        this.setDataPagamento(dataPagamento);
        return this;
    }

    public PagamentoBuilder withFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.setFormaPagamento(formaPagamento);
        return this;
    }

    public PagamentoBuilder withStatusPagamento(StatusPagamentoEnum statusPagamento) {
        this.setStatusPagamento(statusPagamento);
        return this;
    }

    public PagamentoBuilder withCartao(Cartao cartao) {
        this.setCartao(cartao);
        return this;
    }

    public Pagamento build() {
        return this;
    }

}
