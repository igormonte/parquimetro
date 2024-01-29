package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.CartaoRepository;

import java.util.Optional;
import java.util.UUID;

public class CartaoServiceImpl implements CartaoService {

    private CartaoRepository cartaoRepository;

    public CartaoServiceImpl(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public CartaoEntity save(CartaoEntity cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public CartaoEntity update(CartaoEntity cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public Optional<CartaoEntity> findById(UUID uuid) {
        return this.cartaoRepository.findById(uuid);
    }

}
