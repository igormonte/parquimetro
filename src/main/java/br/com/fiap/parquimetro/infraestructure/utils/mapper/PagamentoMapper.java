package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoPagamentoDto;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;

public interface PagamentoMapper {

    Pagamento map (RequestEstacionamentoPagamentoDto requestPagamentoDto);

    Pagamento map(PagamentoEntity entity);

    PagamentoEntity map(Pagamento pagamento);
}
