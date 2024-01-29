package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;

import java.util.Optional;
import java.util.UUID;

public interface EnderecoService {

    EnderecoEntity save(EnderecoEntity endereco);

    EnderecoEntity update(EnderecoEntity endereco);

    Optional<EnderecoEntity> findById(UUID uuid);
    
}
