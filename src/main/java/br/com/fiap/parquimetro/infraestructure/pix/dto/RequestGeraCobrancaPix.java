package br.com.fiap.parquimetro.infraestructure.pix.dto;

import br.com.fiap.parquimetro.infraestructure.pix.model.Beneficiario;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestGeraCobrancaPix {

    private Beneficiario beneficiario;
    private String seuNumero;
    private LocalDate dataCobranca;
    private BigDecimal valor;

}
