package br.com.fiap.parquimetro.infraestructure.pix.service;

import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaDebito;
import br.com.fiap.parquimetro.infraestructure.pix.dto.RequestGeraCobrancaPix;

public interface PixService {

    String geraCobrancaPix(RequestGeraCobrancaPix geraCobranca);

}
