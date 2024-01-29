package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.domain.estacionamento.*;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CartaoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.PagamentoEntity;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.CartaoMapper;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.EstacionamentoMapper;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EstacionamentoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.EstacionamentoRepository;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.PagamentoMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class EstacionamentoServiceImpl implements EstacionamentoService {

    private EstacionamentoRepository estacionamentoRepository;
    private EstacionamentoMapper estacionamentoMapper;

    private CartaoService cartaoService;

    private CartaoMapper cartaoMapper;

    private PagamentoService pagamentoService;

    private PagamentoMapper pagamentoMapper;

    public EstacionamentoServiceImpl(
            EstacionamentoRepository estacionamentoRepository,
            EstacionamentoMapper estacionamentoMapper,
            CartaoService cartaoService,
            CartaoMapper cartaoMapper,
            PagamentoService pagamentoService,
            PagamentoMapper pagamentoMapper) {
        this.estacionamentoRepository = estacionamentoRepository;
        this.estacionamentoMapper = estacionamentoMapper;
        this.cartaoService = cartaoService;
        this.cartaoMapper = cartaoMapper;
        this.pagamentoService = pagamentoService;
        this.pagamentoMapper = pagamentoMapper;
    }

    @Override
    public Estacionamento save(Estacionamento estacionamento) {

//        Pagamento pagamento =estacionamento.getPagamento();
//        CartaoEntity cartao = this.saveCartao(pagamento.getCartao());

        return this.estacionamentoMapper.map(this.estacionamentoRepository.save(
                this.estacionamentoMapper.map(estacionamento)));
    }

    @Override
    public Estacionamento update(Estacionamento estacionamento) {
        return this.estacionamentoMapper.map(this.estacionamentoRepository.save(
                this.estacionamentoMapper.map(estacionamento)));
    }

    @Override
    public Optional<Estacionamento> findById(String uuid) {
        Optional<EstacionamentoEntity> estacionamento =
                this.estacionamentoRepository.findById(UUID.fromString(uuid));
        return estacionamento.map(estacionamentoEntity -> this.estacionamentoMapper.map(estacionamentoEntity));
    }

    @Override
    public List<Estacionamento> findByStatusAndPeriodo(StatusEnum status, PeriodoEnum periodoEnum) {
        List<EstacionamentoEntity> estacionamentoList =
                this.estacionamentoRepository.findByStatusAndPeriodo(status, periodoEnum);

        return estacionamentoList
                .stream()
                .map(e->this.estacionamentoMapper.map(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<Estacionamento> findByCondutorUuid(String uuid) {
        List<EstacionamentoEntity> estacionamentoList =
                this.estacionamentoRepository.findByCondutorUuid(UUID.fromString(uuid));

        return estacionamentoList
                .stream()
                .map(e->this.estacionamentoMapper.map(e))
                .collect(Collectors.toList());
    }

    private CartaoEntity saveCartao(Cartao cartao) {
        return this.cartaoService.save(
                this.cartaoMapper.map(cartao)
        );
    }

    private PagamentoEntity savePagamento(Pagamento pagamento) {
        return this.pagamentoService.save(
                this.pagamentoMapper.map(pagamento)
        );
    }


}
