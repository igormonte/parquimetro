package br.com.fiap.parquimetro.infraestructure.pix.service;

import br.com.fiap.parquimetro.infraestructure.pix.dto.RequestGeraCobrancaPix;

public class PixServiceImpl implements PixService {
    @Override
    public String geraCobrancaPix(RequestGeraCobrancaPix geraCobranca) {
        return String.format("pix://%s-%s",
                geraCobranca.getSeuNumero(),
                geraCobranca.getValor().toString().replace(".", ""));
    }
}
