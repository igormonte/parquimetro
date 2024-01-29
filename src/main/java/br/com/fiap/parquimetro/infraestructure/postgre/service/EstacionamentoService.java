package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EstacionamentoEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstacionamentoService {

    Estacionamento save(Estacionamento estacionamento);

    Estacionamento update(Estacionamento estacionamento);

    Optional<Estacionamento> findById(String uuid);

    List<Estacionamento> findByStatusAndPeriodo(StatusEnum status, PeriodoEnum periodoEnum);

    List<Estacionamento> findByCondutorUuid(String uuid);
}
