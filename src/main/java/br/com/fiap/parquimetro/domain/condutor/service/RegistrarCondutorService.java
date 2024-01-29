package br.com.fiap.parquimetro.domain.condutor.service;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.builder.CondutorBuilder;
import br.com.fiap.parquimetro.domain.condutor.exception.CondutorJaCadastradoException;
import br.com.fiap.parquimetro.domain.condutor.repository.RegistrarCondutor;
import br.com.fiap.parquimetro.infraestructure.postgre.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RegistrarCondutorService implements RegistrarCondutor {

    @Autowired
    private CondutorService condutorService;

    public RegistrarCondutorService(CondutorService condutorService) {
        this.condutorService = condutorService;
    }
    @Override
    public Condutor executar(Condutor condutor) {

        if(!this.isCondutorCadastrado(condutor.getCpf())) {
            return this.condutorService.save(condutor);
        }

        throw new CondutorJaCadastradoException();
    }

    private Boolean isCondutorCadastrado(String cpf) {

        Optional<Condutor> condutor = this.condutorService.findByCpf(cpf);

        if(condutor.isPresent()) {
            return true;

        }

        return false;

    }
}
