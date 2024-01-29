package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;

import java.util.Optional;
import java.util.UUID;

public interface CondutorService {

    Condutor save(Condutor condutor);

    Condutor update(Condutor condutor);

    Optional<Condutor> findById(UUID uuid);

    Optional<Condutor> findByCpf(String cpf);

}
