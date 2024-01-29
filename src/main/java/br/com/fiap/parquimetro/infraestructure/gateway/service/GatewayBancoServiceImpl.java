package br.com.fiap.parquimetro.infraestructure.gateway.service;

import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaCredito;
import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaDebito;

public class GatewayBancoServiceImpl implements GatewayBancoService {
    @Override
    public Boolean geraCobrancaDebito(RequestGeraCobrancaDebito geraCobranca) {
        return true;
    }

    @Override
    public Boolean geraCobrancaCredito(RequestGeraCobrancaCredito geraCobranca) {
        return true;
    }
}
