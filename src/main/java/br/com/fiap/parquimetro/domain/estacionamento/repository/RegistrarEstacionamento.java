package br.com.fiap.parquimetro.domain.estacionamento.repository;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;

public interface RegistrarEstacionamento {

    /*
    * - O sistema permite iniciar o período de estacionamento, oferecendo opções de tempo fixo ou por hora.
    * - Para períodos fixos, o sistema requer que o condutor indique a duração desejada no momento do registro.
    * - Para períodos variáveis, o sistema inicia o tempo de estacionamento automaticamente.
    * - O sistema monitora o tempo com precisão para garantir a cobrança correta
    * - Os condutores têm a opção de pagar pelo estacionamento de várias maneiras, incluindo cartão de crédito,
    *   débito ou PIX, dependendo da forma de pagamento registrada.
    * - A cobrança é baseada no tempo utilizado; para tempos fixos, o valor total é cobrado independentemente do
    *   tempo real utilizado, enquanto para períodos variáveis, a cobrança é por hora completa.
    * */
    Estacionamento executar(Estacionamento estacionamento);
}
