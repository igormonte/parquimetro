package br.com.fiap.parquimetro.domain.condutor.repository;

import br.com.fiap.parquimetro.domain.condutor.Condutor;

public interface RegistrarCondutor {

    /*
    * - Os condutores podem se registrar no sistema, associando seus dados pessoais, como nome, endereço e
        informações de contato.
    * - Um condutor pode vincular vários veículos à sua conta, facilitando o gerenciamento de múltiplos veículos.
    * */
    public Condutor executar(Condutor condutor);

}
