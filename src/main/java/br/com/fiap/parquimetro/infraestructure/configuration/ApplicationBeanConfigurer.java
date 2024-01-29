package br.com.fiap.parquimetro.infraestructure.configuration;

import br.com.fiap.parquimetro.domain.condutor.repository.ConsultaCondutor;
import br.com.fiap.parquimetro.domain.condutor.repository.RegistrarCondutor;
import br.com.fiap.parquimetro.domain.condutor.service.ConsultaCondutorService;
import br.com.fiap.parquimetro.domain.condutor.service.RegistrarCondutorService;
import br.com.fiap.parquimetro.domain.estacionamento.repository.*;
import br.com.fiap.parquimetro.domain.estacionamento.service.*;
import br.com.fiap.parquimetro.infraestructure.gateway.service.GatewayBancoService;
import br.com.fiap.parquimetro.infraestructure.gateway.service.GatewayBancoServiceImpl;
import br.com.fiap.parquimetro.infraestructure.pix.service.PixService;
import br.com.fiap.parquimetro.infraestructure.pix.service.PixServiceImpl;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.*;
import br.com.fiap.parquimetro.infraestructure.postgre.service.*;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBeanConfigurer {


    /*
     * DOMAIN SERVICES
     *
     * */
    @Bean
    public RegistrarCondutor getRegistrarCondutor(CondutorService condutorService) {
        return new RegistrarCondutorService(condutorService);
    }

    @Bean
    public EmiteRecibo getEmiteRecibo() {
        return new EmiteReciboService();
    }

    @Bean
    public FinalizarEstacionamento getFinalizarEstacionamento(
            EstacionamentoService estacionamentoService,
            RealizarPagamento realizarPagamento,
            EmiteRecibo emiteRecibo) {
        return new FinalizarEstacionamentoService(
                estacionamentoService,
                realizarPagamento,
                emiteRecibo
        );
    }

    @Bean
    public RealizarPagamento getRealizarPagamento(
            PixService pixService,
            GatewayBancoService gatewayBancoService) {
        return new RealizarPagamentoService(
                pixService,
                gatewayBancoService
        );
    }

    @Bean
    public ConsultaEstacionamento getConsultaEstacionamentoService(
            EstacionamentoService estacionamentoService) {
        return new ConsultaEstacionamentoService(estacionamentoService);
    }

    @Bean
    public AlertaExpiracaoEstacionamento getAlertaExpiracaoEstacionamento(
            ConsultaEstacionamento consultaEstacionamento
    ){
        return new AlertaExpiracaoEstacionamentoService(consultaEstacionamento);
    }
    @Bean
    public AlertaTempoEstacionamento getAlertaTempoEstacionamento(
            ConsultaEstacionamento consultaEstacionamento
    ){
        return new AlertaTempoEstacionamentoService(consultaEstacionamento);
    }
    @Bean
    public NotificarExpiracaoEstacionamento getNotificarExpiracaoEstacionamento(
            ConsultaEstacionamento consultaEstacionamento
    ){
        return new NotificarExpiracaoEstacionamentoService(consultaEstacionamento);
    }

    @Bean
    public RegistrarEstacionamento getRegistrarEstacionamento(
            EstacionamentoService estacionamentoService,
            RealizarPagamento realizarPagamento,
            EmiteRecibo emiteRecibo
    ) {
        return new RegistrarEstacionamentoService(
                estacionamentoService,
                realizarPagamento,
                emiteRecibo
        );
    }

    @Bean
    public RealizarFechamentoEstacionamento getRealizarFechamentoEstacionamento(
            ConsultaEstacionamento consultaEstacionamento,
            FinalizarEstacionamento finalizarEstacionamento,
            NotificarExpiracaoEstacionamento notificarExpiracaoEstacionamento
    ){
        return new RealizarFechamentoEstacionamentoService(
                consultaEstacionamento,
                finalizarEstacionamento,
                notificarExpiracaoEstacionamento
        );
    }

    @Bean
    public ConsultaCondutor getConsultaCondutor(CondutorService condutorService){
        return new ConsultaCondutorService(condutorService);
    }


    /*
    * MAPPERS
    *
    * */
    @Bean
    public CondutorMapper getCondutorMapper( EnderecoMapper enderecoMapper,
                                             VeiculoMapper veiculoMapper) {
        return new CondutorMapperImpl(enderecoMapper, veiculoMapper);
    }

    @Bean
    public EnderecoMapper getEnderecoMapper() {
        return new EnderecoMapperImpl();
    }

    @Bean
    public EstacionamentoMapper getEstacionamentoMapper(
            CondutorMapper condutorMapper,
            EnderecoMapper enderecoMapper,
            VeiculoMapper veiculoMapper,
            PagamentoMapper pagamentoMapper) {
        return new EstacionamentoMapperImpl(
                condutorMapper,
                enderecoMapper,
                veiculoMapper,
                pagamentoMapper
        );
    }

    @Bean
    public VeiculoMapper getVeiculoMapper() {
        return new VeiculoMapperImpl();
    }

    @Bean
    public PagamentoMapper getPagamentoMapper(CartaoMapper cartaoMapper) {
        return new PagamentoMapperImpl(cartaoMapper);
    }

    @Bean
    public CartaoMapper getCartaoMapper() {
        return new CartaoMapperImpl();
    }


    /*
     * DB SERVICES
     *
     * */
    @Bean
    public CondutorService getCondutorService(
            CondutorRepository condutorRepository,
            CondutorMapper condutorMapper,
            EnderecoService enderecoService,
            EnderecoMapper enderecoMapper,
            VeiculoService veiculoService,
            VeiculoMapper veiculoMapper) {
        return new CondutorServiceImpl(
                condutorRepository,
                condutorMapper,
                enderecoService,
                enderecoMapper,
                veiculoService,
                veiculoMapper);
    }

    @Bean
    public EnderecoService getEnderecoService(
            EnderecoRepository enderecoRepository) {
        return new EnderecoServiceImpl(enderecoRepository);
    }

    @Bean
    public EstacionamentoService getEstacionamentoService(
            EstacionamentoRepository estacionamentoRepository,
            EstacionamentoMapper estacionamentoMapper,
            CartaoService cartaoService,
            CartaoMapper cartaoMapper,
            PagamentoService pagamentoService,
            PagamentoMapper pagamentoMapper){
        return new EstacionamentoServiceImpl(
                estacionamentoRepository,
                estacionamentoMapper,
                cartaoService,
                cartaoMapper,
                pagamentoService,
                pagamentoMapper);
    }

    @Bean
    public VeiculoService getVeiculoService(VeiculoRepository veiculoRepository){
        return new VeiculoServiceImpl(veiculoRepository);
    }

    @Bean
    public CartaoService getCartaoService(CartaoRepository cartaoRepository) {
        return new CartaoServiceImpl(cartaoRepository);
    }

    @Bean
    public PagamentoService getPagamentoService(PagamentoRepository pagamentoRepositor) {
        return new PagamentoServiceImpl(pagamentoRepositor);
    }



    /*
     * PIX SERVICE
     *
     * */
    @Bean
    public PixService getPixService() {
        return new PixServiceImpl();
    }


    /*
     * GATEWAY SERVICE
     *
     * */
    @Bean
    public GatewayBancoService getGatewayBancoService() {
        return new GatewayBancoServiceImpl();
    }

}
