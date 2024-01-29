package br.com.fiap.parquimetro.infraestructure.utils.mapper;


import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoVeiculoDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestVeiculoDto;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.condutor.builder.VeiculoBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.CondutorEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.VeiculoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VeiculoMapperImpl implements VeiculoMapper {

    @Override
    public Veiculo map(RequestEstacionamentoVeiculoDto requestEstacionamentoVeiculoDto) {
        return new VeiculoBuilder()
                .withUuid(requestEstacionamentoVeiculoDto.uuid())
                .build();
    }

    @Override
    public Veiculo map(RequestVeiculoDto requestVeiculoDto) {
        return new VeiculoBuilder()
            .withNome(requestVeiculoDto.nome())
            .withPlaca(requestVeiculoDto.placa())
            .build();
    }

    @Override
    public Veiculo map (VeiculoEntity veiculoEntity) {
        return new VeiculoBuilder()
            .withUuid(veiculoEntity.getUuid().toString())
            .withNome(veiculoEntity.getNome())
            .withPlaca(veiculoEntity.getPlaca())
            .withInativo(veiculoEntity.getInativo())
            .build();
    }

    @Override
    public VeiculoEntity map (String uuidCondutor, Veiculo veiculo) {
        return new VeiculoEntityBuilder()
            .withUuid(veiculo.getUuid() != null?
                    UUID.fromString(veiculo.getUuid()) :
                    null)
            .withCondutor(new CondutorEntityBuilder()
                    .withUuid(UUID.fromString(uuidCondutor))
                    .build())
            .withNome(veiculo.getNome())
            .withPlaca(veiculo.getPlaca())
            .withInativo(veiculo.getInativo())
            .build();
    }

}
