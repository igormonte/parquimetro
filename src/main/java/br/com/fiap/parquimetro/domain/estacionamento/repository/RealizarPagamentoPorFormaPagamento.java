package br.com.fiap.parquimetro.domain.estacionamento.repository;


import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;

public interface RealizarPagamentoPorFormaPagamento {

    public Boolean execute(Estacionamento estacionamento);

}
