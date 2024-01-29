package br.com.fiap.parquimetro.infraestructure.postgre.repository;

import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EstacionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstacionamentoRepository extends JpaRepository<EstacionamentoEntity, UUID> {

    public List<EstacionamentoEntity> findByStatusAndPeriodo(StatusEnum status, PeriodoEnum periodoEnum);

    List<EstacionamentoEntity> findByCondutorUuid(UUID uuid);
}
