package br.com.fiap.parquimetro.domain.estacionamento.repository;

import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;

public interface NotificarExpiracaoEstacionamento {

    /*
    * - O sistema inclui um recurso de alerta que notifica o condutor quando o tempo de estacionamento está
    *   prestes a expirar, no caso de horário fixo.
    * - Para períodos variáveis, o sistema também emite um alerta informando que o sistema estenderá
    *   automaticamente o estacionamento por mais uma hora, a menos que o condutor desligue o registro.
    * */
    void executar(Estacionamento estacionamento);
}
