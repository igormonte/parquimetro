package br.com.fiap.parquimetro.domain.condutor.repository;

import br.com.fiap.parquimetro.domain.condutor.Condutor;

import java.util.List;
import java.util.Optional;

public interface ConsultaCondutor {

    public Optional<Condutor> findById(String id);

}
