package br.com.fiap.parquimetro.domain.estacionamento.repository;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;

import java.util.List;
import java.util.Optional;

public interface ConsultaEstacionamento {

    public Optional<Estacionamento> findById(String id);
    public List<Estacionamento> findByStatusAndPeriodo(StatusEnum status, PeriodoEnum periodoEnum);

    public List<Estacionamento> findByCondutorUuid(String uuid);
}
