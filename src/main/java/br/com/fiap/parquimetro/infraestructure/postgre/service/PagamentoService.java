package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;

import java.util.Optional;
import java.util.UUID;

public interface PagamentoService {

    PagamentoEntity save(PagamentoEntity pagamento);

    PagamentoEntity update(PagamentoEntity pagamento);

    Optional<PagamentoEntity> findById(UUID uuid);

}
