package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoVeiculoDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestVeiculoDto;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.util.List;

public interface VeiculoMapper {

    Veiculo map (RequestEstacionamentoVeiculoDto requestEstacionamentoVeiculoDto);

    Veiculo map (RequestVeiculoDto requestVeiculoDto);

    Veiculo map(VeiculoEntity entity);

    VeiculoEntity map(String uuidCondutor, Veiculo veiculo);

}
