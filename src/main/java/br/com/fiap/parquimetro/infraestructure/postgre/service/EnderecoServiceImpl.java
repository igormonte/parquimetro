package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.EnderecoRepository;

import java.util.Optional;
import java.util.UUID;

public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public EnderecoEntity save(EnderecoEntity endereco) {
        return this.enderecoRepository.save(endereco);
    }

    @Override
    public EnderecoEntity update(EnderecoEntity endereco) {
        return this.enderecoRepository.save(endereco);
    }

    @Override
    public Optional<EnderecoEntity> findById(UUID uuid) {
        return this.enderecoRepository.findById(uuid);
    }

}
