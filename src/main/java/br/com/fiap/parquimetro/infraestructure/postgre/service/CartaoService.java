package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;

import java.util.Optional;
import java.util.UUID;

public interface CartaoService {

    CartaoEntity save(CartaoEntity cartao);

    CartaoEntity update(CartaoEntity cartao);

    Optional<CartaoEntity> findById(UUID uuid);

}
