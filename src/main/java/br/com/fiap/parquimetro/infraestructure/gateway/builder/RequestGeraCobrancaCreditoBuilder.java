package br.com.fiap.parquimetro.infraestructure.gateway.builder;

import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaCredito;
import br.com.fiap.parquimetro.infraestructure.gateway.model.Beneficiario;
import br.com.fiap.parquimetro.infraestructure.gateway.model.Pagador;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestGeraCobrancaCreditoBuilder {

    private RequestGeraCobrancaCredito requestGeraCobrancaCredito;

    public RequestGeraCobrancaCreditoBuilder() {
        this.requestGeraCobrancaCredito = new RequestGeraCobrancaCredito();
        this.requestGeraCobrancaCredito.setBeneficiario(new Beneficiario());
    }

    public RequestGeraCobrancaCreditoBuilder withPagador (Pagador pagador){
        this.requestGeraCobrancaCredito.setPagador(pagador);
        return this;

    }
    public RequestGeraCobrancaCreditoBuilder withSeuNumero (String seuNumero){
        this.requestGeraCobrancaCredito.setSeuNumero(seuNumero);
        return this;

    }
    public RequestGeraCobrancaCreditoBuilder withLocalDate (LocalDate dataCobranca){
        this.requestGeraCobrancaCredito.setDataCobranca(dataCobranca);
        return this;

    }
    public RequestGeraCobrancaCreditoBuilder withBigDecimal (BigDecimal valor){
        this.requestGeraCobrancaCredito.setValor(valor);
        return this;

    }

    public RequestGeraCobrancaCredito build() {
        return this.requestGeraCobrancaCredito;
    }

}
