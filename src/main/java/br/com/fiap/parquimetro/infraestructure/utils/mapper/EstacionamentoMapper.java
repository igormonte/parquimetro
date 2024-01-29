package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoDto;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EstacionamentoEntity;

public interface EstacionamentoMapper {

    Estacionamento map (RequestEstacionamentoDto requestEstacionamentoDto);

    Estacionamento map(EstacionamentoEntity entity);

    EstacionamentoEntity map(Estacionamento estacionamento);
}
