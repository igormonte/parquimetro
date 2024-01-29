package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestCondutorDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoCondutorDto;
import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;

public interface CondutorMapper {

    Condutor map (RequestEstacionamentoCondutorDto requestEstacionamentoCondutorDto);

    Condutor map (RequestCondutorDto requestCondutorDto);

    Condutor map(CondutorEntity entity);

    CondutorEntity map(Condutor condutor);
}
