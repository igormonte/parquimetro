package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.PagamentoRepository;

import java.util.Optional;
import java.util.UUID;

public class PagamentoServiceImpl implements PagamentoService {

    private PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public PagamentoEntity save(PagamentoEntity pagamento) {
        return this.pagamentoRepository.save(pagamento);
    }

    @Override
    public PagamentoEntity update(PagamentoEntity pagamento) {
        return this.pagamentoRepository.save(pagamento);
    }

    @Override
    public Optional<PagamentoEntity> findById(UUID uuid) {
        return this.pagamentoRepository.findById(uuid);
    }

}
