package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.VeiculoRepository;

import java.util.Optional;
import java.util.UUID;

public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public VeiculoEntity save(VeiculoEntity veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    @Override
    public VeiculoEntity update(VeiculoEntity veiculo) {
        return this.veiculoRepository.save(veiculo);
    }

    @Override
    public Optional<VeiculoEntity> findById(UUID uuid) {
        return this.veiculoRepository.findById(uuid);
    }

}
