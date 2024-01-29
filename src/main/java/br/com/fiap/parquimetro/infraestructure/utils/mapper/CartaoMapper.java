package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoPagamentoCartaoDto;
import br.com.fiap.parquimetro.domain.estacionamento.Cartao;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;

public interface CartaoMapper {


    Cartao map (RequestEstacionamentoPagamentoCartaoDto requestCartaoDto);

    Cartao map(CartaoEntity entity);

    CartaoEntity map(Cartao Cartao);
}
