package br.com.fiap.parquimetro.infraestructure.postgre.repository;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, UUID> {
}
