package br.com.fiap.parquimetro.infraestructure.postgre.repository;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID> {

}
