package br.com.fiap.parquimetro.infraestructure.utils.mapper;


import br.com.fiap.parquimetro.application.rest.dto.request.RequestEnderecoDto;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import br.com.fiap.parquimetro.domain.condutor.builder.EnderecoBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.EnderecoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;

import java.util.UUID;

public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public Endereco map(RequestEnderecoDto requestEnderecoDto) {
        return new EnderecoBuilder()
                .withRua(requestEnderecoDto.rua())
                .withNumero(requestEnderecoDto.numero())
                .withBairro(requestEnderecoDto.bairro())
                .withCidade(requestEnderecoDto.cidade())
                .withUf(requestEnderecoDto.uf())
                .withCep(requestEnderecoDto.cep())
                .build();
    }

    @Override
    public Endereco map (EnderecoEntity enderecoEntity) {
        return new EnderecoBuilder()
                .withUUid(enderecoEntity.getUuid().toString())
                .withRua(enderecoEntity.getRua())
                .withNumero(enderecoEntity.getNumero())
                .withBairro(enderecoEntity.getBairro())
                .withCidade(enderecoEntity.getCidade())
                .withUf(enderecoEntity.getUf())
                .withCep(enderecoEntity.getCep())
                .build();
    }

    @Override
    public EnderecoEntity map (Endereco endereco) {
        return new EnderecoEntityBuilder()
                .withUUid(endereco.getUuid() != null?
                        UUID.fromString(endereco.getUuid()): null)
                .withRua(endereco.getRua())
                .withNumero(endereco.getNumero())
                .withBairro(endereco.getBairro())
                .withCidade(endereco.getCidade())
                .withUf(endereco.getUf())
                .withCep(endereco.getCep())
                .build();
    }

}
