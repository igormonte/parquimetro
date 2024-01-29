package br.com.fiap.parquimetro.domain.condutor.service;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.repository.ConsultaCondutor;
import br.com.fiap.parquimetro.infraestructure.postgre.service.CondutorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ConsultaCondutorService implements ConsultaCondutor {

    private CondutorService condutorService;

    public ConsultaCondutorService(CondutorService condutorService) {
        this.condutorService = condutorService;
    }

    @Override
    public Optional<Condutor> findById(String uuid) {
        return this.condutorService.findById(UUID.fromString(uuid));
    }

}
