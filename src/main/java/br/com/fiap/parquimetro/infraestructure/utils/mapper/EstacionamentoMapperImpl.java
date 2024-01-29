package br.com.fiap.parquimetro.infraestructure.utils.mapper;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoPagamentoCartaoDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoPagamentoDto;
import br.com.fiap.parquimetro.domain.condutor.builder.CondutorBuilder;
import br.com.fiap.parquimetro.domain.condutor.builder.VeiculoBuilder;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.Valor;
import br.com.fiap.parquimetro.domain.estacionamento.builder.CartaoBuilder;
import br.com.fiap.parquimetro.domain.estacionamento.builder.EstacionamentoBuilder;
import br.com.fiap.parquimetro.domain.estacionamento.builder.PagamentoBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.EstacionamentoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EstacionamentoEntity;

import java.util.UUID;

public class EstacionamentoMapperImpl implements EstacionamentoMapper {

    private CondutorMapper condutorMapper;
    private EnderecoMapper enderecoMapper;
    private VeiculoMapper veiculoMapper;
    private PagamentoMapper pagamentoMapper;

    public EstacionamentoMapperImpl(
            CondutorMapper condutorMapper,
            EnderecoMapper enderecoMapper,
            VeiculoMapper veiculoMapper,
            PagamentoMapper pagamentoMapper) {
        this.condutorMapper = condutorMapper;
        this.enderecoMapper = enderecoMapper;
        this.veiculoMapper = veiculoMapper;
        this.pagamentoMapper = pagamentoMapper;
    }


    @Override
    public Estacionamento map(RequestEstacionamentoDto requestEstacionamentoDto) {
        RequestEstacionamentoPagamentoDto pagamento =
                requestEstacionamentoDto.pagamento();
        RequestEstacionamentoPagamentoCartaoDto cartao =
                pagamento.cartao();
        return new EstacionamentoBuilder()
                .withCondutor(
                        this.condutorMapper.map(requestEstacionamentoDto.condutor())
                )
                .withVeiculo(this.veiculoMapper.map(requestEstacionamentoDto.veiculo())
                )
                .withPeriodo(requestEstacionamentoDto.periodo())
                .withTempo(requestEstacionamentoDto.tempo())
                .withPagamento(this.pagamentoMapper.map(pagamento)
                )
            .build();
    }

    @Override
    public Estacionamento map (EstacionamentoEntity estacionamentoEntity) {
        return new EstacionamentoBuilder()
            .withUuid(estacionamentoEntity.getUuid().toString())
            .withPeriodo(estacionamentoEntity.getPeriodo())
            .withTempo(estacionamentoEntity.getTempo())
            .withDataPrevisaoSaida(estacionamentoEntity.getDataPrevisaoSaida())
            .withDataCriacao(estacionamentoEntity.getDataCriacao())
            .withDataFinalizacao(estacionamentoEntity.getDataFinalizacao())
            .withCondutor(
                    this.condutorMapper.map(estacionamentoEntity.getCondutor())
            )
            .withVeiculo(
                this.veiculoMapper.map(estacionamentoEntity.getVeiculo())
            )
            .withPagamento(
                this.pagamentoMapper.map(estacionamentoEntity.getPagamento())
            )
            .withStatus(estacionamentoEntity.getStatus())
            .withValor(new Valor(estacionamentoEntity.getValor()))
            .build();
    }

    @Override
    public EstacionamentoEntity map (Estacionamento estacionamento) {
        return new EstacionamentoEntityBuilder()
            .withUuid(estacionamento.getUuid() != null?
                    UUID.fromString(estacionamento.getUuid())
                    : null)
            .withPeriodo(estacionamento.getPeriodo())
            .withTempo(estacionamento.getTempo())
            .withDataPrevisaoSaida(estacionamento.getDataPrevisaoSaida())
            .withDataCriacao(estacionamento.getDataCriacao())
            .withDataFinalizacao(estacionamento.getDataFinalizacao())
            .withCondutor(
                    this.condutorMapper.map(estacionamento.getCondutor())
            )
            .withVeiculo(
                    this.veiculoMapper.map(
                            estacionamento.getCondutor().getUuid(),
                            estacionamento.getVeiculo())
            )
            .withPagamento(
                    this.pagamentoMapper.map(estacionamento.getPagamento())
            )
            .withStatus(estacionamento.getStatus())
            .withValor(estacionamento.getValor() == null? null
                    : estacionamento.getValor().getValor())
            .build();
    }

}
