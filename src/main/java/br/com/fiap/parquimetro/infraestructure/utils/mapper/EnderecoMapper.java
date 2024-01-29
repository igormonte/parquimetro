package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEnderecoDto;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;

public interface EnderecoMapper {


    Endereco map (RequestEnderecoDto requestEnderecoDto);

    Endereco map(EnderecoEntity entity);

    EnderecoEntity map(Endereco endereco);
}
