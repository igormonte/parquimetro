package br.com.fiap.parquimetro.infraestructure.gateway.service;

import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaCredito;
import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaDebito;

public interface GatewayBancoService {

    Boolean geraCobrancaDebito(RequestGeraCobrancaDebito geraCobranca);
    Boolean geraCobrancaCredito(RequestGeraCobrancaCredito geraCobranca);

}
