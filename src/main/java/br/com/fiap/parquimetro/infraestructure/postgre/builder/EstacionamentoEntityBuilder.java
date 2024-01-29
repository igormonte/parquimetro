package br.com.fiap.parquimetro.infraestructure.postgre.builder;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Valor;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EstacionamentoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class EstacionamentoEntityBuilder {

    private EstacionamentoEntity estacionamento;

    public EstacionamentoEntityBuilder() {
        this.estacionamento = new EstacionamentoEntity();
    }
    
    public EstacionamentoEntityBuilder withUuid(UUID uuid) {
        this.estacionamento.setUuid(uuid);
        return this;
    }

    public EstacionamentoEntityBuilder withPeriodo(PeriodoEnum periodo) {
        this.estacionamento.setPeriodo(periodo);
        return this;
    }

    public EstacionamentoEntityBuilder withTempo(Long tempo) {
        this.estacionamento.setTempo(tempo);
        return this;
    }


    public EstacionamentoEntityBuilder withDataPrevisaoSaida(LocalDateTime dataPrevisaoSaida) {
        this.estacionamento.setDataPrevisaoSaida(dataPrevisaoSaida);
        return this;
    }

    public EstacionamentoEntityBuilder withDataCriacao(LocalDateTime dataCriacao) {
        this.estacionamento.setDataCriacao(dataCriacao);
        return this;
    }

    public EstacionamentoEntityBuilder withDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.estacionamento.setDataFinalizacao(dataFinalizacao);
        return this;
    }

    public EstacionamentoEntityBuilder withCondutor(CondutorEntity condutor) {
        this.estacionamento.setCondutor(condutor);
        return this;
    }

    public EstacionamentoEntityBuilder withVeiculo(VeiculoEntity veiculo) {
        this.estacionamento.setVeiculo(veiculo);
        return this;
    }

    public EstacionamentoEntityBuilder withPagamento(PagamentoEntity pagamento) {
        this.estacionamento.setPagamento(pagamento);
        return this;
    }

    public EstacionamentoEntityBuilder withStatus(StatusEnum status) {
        this.estacionamento.setStatus(status);
        return this;
    }

    public EstacionamentoEntityBuilder withValor(BigDecimal valor) {
        this.estacionamento.setValor(valor);
        return this;
    }

    public EstacionamentoEntity build() {
        return this.estacionamento;
    }

}
