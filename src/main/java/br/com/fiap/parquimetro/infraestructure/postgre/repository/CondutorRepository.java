package br.com.fiap.parquimetro.infraestructure.postgre.repository;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CondutorRepository extends JpaRepository<CondutorEntity, UUID> {
    Optional<CondutorEntity> findByCpf(String cpf);
}
