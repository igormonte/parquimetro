package br.com.fiap.parquimetro.infraestructure.gateway.dto;

import br.com.fiap.parquimetro.infraestructure.gateway.model.Beneficiario;
import br.com.fiap.parquimetro.infraestructure.gateway.model.Pagador;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestGeraCobrancaCredito {

    private Beneficiario beneficiario;
    private Pagador pagador;
    private String seuNumero;
    private LocalDate dataCobranca;
    private BigDecimal valor;

}
