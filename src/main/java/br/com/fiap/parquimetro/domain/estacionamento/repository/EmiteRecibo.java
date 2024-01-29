package br.com.fiap.parquimetro.domain.estacionamento.repository;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;

public interface EmiteRecibo {

    /*
    * - O sistema emite recibos automaticamente sempre que o tempo de estacionamento é encerrado e a
    *   cobrança é realizada.
    * - Os recibos fornecem informações detalhadas, incluindo o tempo estacionado, a tarifa aplicada e o valor
    *   total pago.
    * */
    void executar(Estacionamento estacionamento);

}
