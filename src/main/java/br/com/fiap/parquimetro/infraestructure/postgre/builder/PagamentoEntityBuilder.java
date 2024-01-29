package br.com.fiap.parquimetro.infraestructure.postgre.builder;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusPagamentoEnum;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoEntityBuilder {

    private PagamentoEntity pagamento;

    public PagamentoEntityBuilder(){
        this.pagamento = new PagamentoEntity();
    }

    public PagamentoEntityBuilder withUuid(UUID uuid) {
        this.pagamento.setUuid(uuid);
        return this;
    }

    public PagamentoEntityBuilder withValor(BigDecimal valor) {
        this.pagamento.setValor(valor);
        return this;
    }

    public PagamentoEntityBuilder withDataCriacao(LocalDateTime dataCriacao) {
        this.pagamento.setDataCriacao(dataCriacao);
        return this;
    }

    public PagamentoEntityBuilder withDataPagamento(LocalDateTime dataPagamento) {
        this.pagamento.setDataPagamento(dataPagamento);
        return this;
    }

    public PagamentoEntityBuilder withFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.pagamento.setFormaPagamento(formaPagamento);
        return this;
    }

    public PagamentoEntityBuilder withStatusPagamento(StatusPagamentoEnum statusPagamento) {
        this.pagamento.setStatusPagamento(statusPagamento);
        return this;
    }

    public PagamentoEntityBuilder withCartao(CartaoEntity cartao) {
        this.pagamento.setCartao(cartao);
        return this;
    }

    public PagamentoEntity build() {
        return this.pagamento;
    }

}
