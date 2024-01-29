package br.com.fiap.parquimetro.infraestructure.utils.mapper;


import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoPagamentoCartaoDto;
import br.com.fiap.parquimetro.domain.estacionamento.Cartao;
import br.com.fiap.parquimetro.domain.estacionamento.builder.CartaoBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.CondutorEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.CartaoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;

import java.util.UUID;

public class CartaoMapperImpl implements CartaoMapper {

    @Override
    public Cartao map(RequestEstacionamentoPagamentoCartaoDto requestCartaoDto) {
        return new CartaoBuilder()
            .withNumeroCartao(requestCartaoDto.numeroCartao())
            .withNomeTitular(requestCartaoDto.nomeTitular())
            .withCvv(requestCartaoDto.cvv())
            .build();
    }

    @Override
    public Cartao map (CartaoEntity cartaoEntity) {
        return new CartaoBuilder()
            .withUuid(cartaoEntity.getUuid().toString())
            .withNumeroCartao(cartaoEntity.getNumeroCartao())
            .withNomeTitular(cartaoEntity.getNomeTitular())
            .withCvv(cartaoEntity.getCvv())
            .build();
    }

    @Override
    public CartaoEntity map (Cartao cartao) {
        return new CartaoEntityBuilder()
            .withUuid(cartao.getUuid() != null?
                    UUID.fromString(cartao.getUuid())
                    : null)
            .withNumeroCartao(cartao.getNumeroCartao())
            .withNomeTitular(cartao.getNomeTitular())
            .withCvv(cartao.getCvv())
            .build();
    }

}
