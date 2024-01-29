package br.com.fiap.parquimetro.domain.estacionamento.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.repository.ConsultaEstacionamento;
import br.com.fiap.parquimetro.infraestructure.postgre.service.EstacionamentoService;

import java.util.List;
import java.util.Optional;

public class ConsultaEstacionamentoService implements ConsultaEstacionamento {

    private EstacionamentoService estacionamentoService;

    public ConsultaEstacionamentoService(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
    }

    @Override
    public Optional<Estacionamento> findById(String id) {
        return this.estacionamentoService.findById(id);
    }

    @Override
    public List<Estacionamento> findByStatusAndPeriodo(StatusEnum status, PeriodoEnum periodo) {
        return this.estacionamentoService.findByStatusAndPeriodo(status, periodo);
    }

    @Override
    public List<Estacionamento> findByCondutorUuid(String uuid) {
        return this.estacionamentoService.findByCondutorUuid(uuid);
    }
}
