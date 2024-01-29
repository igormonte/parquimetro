package br.com.fiap.parquimetro.infraestructure.utils.mapper;


import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoPagamentoDto;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.builder.PagamentoBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.CondutorEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.PagamentoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;

import java.util.UUID;

public class PagamentoMapperImpl implements PagamentoMapper {

    private CartaoMapper cartaoMapper;

    public PagamentoMapperImpl(CartaoMapper cartaoMapper) {
        this.cartaoMapper = cartaoMapper;
    }

    @Override
    public Pagamento map(RequestEstacionamentoPagamentoDto requestPagamentoDto) {
        return new PagamentoBuilder()
                .withFormaPagamento(requestPagamentoDto.formaPagamento())
                .withCartao(requestPagamentoDto.cartao() == null ? null
                    : this.cartaoMapper.map(requestPagamentoDto.cartao()))
            .build();
    }

    @Override
    public Pagamento map (PagamentoEntity pagamentoEntity) {
        return new PagamentoBuilder()
            .withUuid(pagamentoEntity.getUuid().toString())
            .withValor(pagamentoEntity.getValor())
            .withDataCriacao(pagamentoEntity.getDataCriacao())
            .withDataPagamento(pagamentoEntity.getDataPagamento())
            .withFormaPagamento(pagamentoEntity.getFormaPagamento())
            .withStatusPagamento(pagamentoEntity.getStatusPagamento())
            .withCartao(pagamentoEntity.getCartao() == null ? null
                : this.cartaoMapper.map(pagamentoEntity.getCartao()))
            .build();
    }

    @Override
    public PagamentoEntity map (Pagamento pagamento) {
        return new PagamentoEntityBuilder()
            .withUuid(pagamento.getUuid() != null?
                    UUID.fromString(pagamento.getUuid()) :
                    null)
            .withValor(pagamento.getValor())
            .withDataCriacao(pagamento.getDataCriacao())
            .withDataPagamento(pagamento.getDataPagamento())
            .withFormaPagamento(pagamento.getFormaPagamento())
            .withStatusPagamento(pagamento.getStatusPagamento())
            .withCartao(pagamento.getCartao() == null ? null
                : this.cartaoMapper.map(pagamento.getCartao()))
            .build();
    }

}
