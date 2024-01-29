package br.com.fiap.parquimetro.infraestructure.utils.mapper;


import br.com.fiap.parquimetro.application.rest.dto.request.RequestCondutorDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestEnderecoDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoCondutorDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestVeiculoDto;
import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.condutor.builder.CondutorBuilder;
import br.com.fiap.parquimetro.domain.condutor.builder.EnderecoBuilder;
import br.com.fiap.parquimetro.domain.condutor.builder.VeiculoBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.CondutorEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.EnderecoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.VeiculoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CondutorMapperImpl implements CondutorMapper {

    private EnderecoMapper enderecoMapper;
    private VeiculoMapper veiculoMapper;

    public CondutorMapperImpl(
            EnderecoMapper enderecoMapper,
            VeiculoMapper veiculoMapper) {
        this.enderecoMapper = enderecoMapper;
        this.veiculoMapper = veiculoMapper;
    }

    @Override
    public Condutor map(RequestEstacionamentoCondutorDto requestEstacionamentoCondutorDto) {
        return new CondutorBuilder()
                .withUuid(requestEstacionamentoCondutorDto.uuid());
    }

    @Override
    public Condutor map(RequestCondutorDto requestCondutorDto) {
        List<RequestVeiculoDto> veiculos = requestCondutorDto.veiculo();
        RequestEnderecoDto endereco = requestCondutorDto.endereco();

        return new CondutorBuilder()
            .withNome(requestCondutorDto.nome())
            .withEmail(requestCondutorDto.email())
            .withCpf(requestCondutorDto.cpf())
            .withSenha(requestCondutorDto.senha())
            .withVeiculos(veiculos
                .stream().map(v->
                    this.veiculoMapper.map(v))
                    .collect(Collectors.toList()))
            .withEndereco(
                    this.enderecoMapper.map(endereco))
            .withFormaPagamentoPadrao(requestCondutorDto.formaPagamentoPadrao())
            .build();
    }

    @Override
    public Condutor map (CondutorEntity condutorEntity) {
        List<VeiculoEntity> veiculosEntity = condutorEntity.getVeiculo();
        EnderecoEntity enderecoEntity = condutorEntity.getEndereco();

        return new CondutorBuilder()
            .withUuid(condutorEntity.getUuid().toString())
            .withNome(condutorEntity.getNome())
            .withEmail(condutorEntity.getEmail())
            .withCpf(condutorEntity.getCpf())
            .withVeiculos(veiculosEntity == null ? null
                    : veiculosEntity
                    .stream().map(v->
                            this.veiculoMapper.map(v))
                    .collect(Collectors.toList()))
            .withEndereco(enderecoEntity == null ? null
                    : this.enderecoMapper.map(enderecoEntity))
            .withFormaPagamentoPadrao(condutorEntity.getFormaPagamentoPadrao())
            .build();
    }

    @Override
    public CondutorEntity map (Condutor condutor) {
        List<Veiculo> veiculo = condutor.getVeiculo();
        Endereco endereco = condutor.getEndereco();

        return new CondutorEntityBuilder()
            .withUuid(UUID.fromString(condutor.getUuid()))
            .withNome(condutor.getNome())
            .withEmail(condutor.getEmail())
            .withCpf(condutor.getCpf())
            .withSenha(condutor.getSenha())
            .withVeiculos(veiculo == null? null
                    :veiculo.stream().map(v->
                            this.veiculoMapper.map(condutor.getUuid(),v))
                    .collect(Collectors.toList()))
            .withEndereco(endereco == null ? null
                    : this.enderecoMapper.map(endereco))
            .withFormaPagamentoPadrao(condutor.getFormaPagamentoPadrao())
            .build();
    }

}
