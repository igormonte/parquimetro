package br.com.fiap.parquimetro.domain.estacionamento.builder;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.estacionamento.*;
import br.com.fiap.parquimetro.infraestructure.postgre.builder.EstacionamentoEntityBuilder;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class EstacionamentoBuilder extends Estacionamento {

    public EstacionamentoBuilder() {
    }
    
    public EstacionamentoBuilder withUuid(String uuid) {
        this.setUuid(uuid);
        return this;
    }

    public EstacionamentoBuilder withPeriodo(PeriodoEnum periodo) {
        this.setPeriodo(periodo);
        return this;
    }

    public EstacionamentoBuilder withTempo(Long tempo) {
        this.setTempo(tempo);
        return this;
    }

    public EstacionamentoBuilder withDataPrevisaoSaida(LocalDateTime dataPrevisaoSaida) {
        this.setDataPrevisaoSaida(dataPrevisaoSaida);
        return this;
    }

    public EstacionamentoBuilder withDataCriacao(LocalDateTime dataCriacao) {
        this.setDataCriacao(dataCriacao);
        return this;
    }

    public EstacionamentoBuilder withDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.setDataFinalizacao(dataFinalizacao);
        return this;
    }

    public EstacionamentoBuilder withCondutor(Condutor condutor) {
        this.setCondutor(condutor);
        return this;
    }

    public EstacionamentoBuilder withVeiculo(Veiculo veiculo) {
        this.setVeiculo(veiculo);
        return this;
    }

    public EstacionamentoBuilder withPagamento(Pagamento pagamento) {
        this.setPagamento(pagamento);
        return this;
    }

    public EstacionamentoBuilder withStatus(StatusEnum status) {
        this.setStatus(status);
        return this;
    }

    public EstacionamentoBuilder withValor(Valor valor) {
        this.setValor(valor);
        return this;
    }

    public Estacionamento build() {
        return this;
    }

}
