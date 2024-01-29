package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;

import java.util.Optional;
import java.util.UUID;

public interface VeiculoService {

    VeiculoEntity save(VeiculoEntity veiculo);

    VeiculoEntity update(VeiculoEntity veiculo);

    Optional<VeiculoEntity> findById(UUID uuid);

}
