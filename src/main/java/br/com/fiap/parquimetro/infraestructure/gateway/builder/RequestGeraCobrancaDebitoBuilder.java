package br.com.fiap.parquimetro.infraestructure.gateway.builder;

import br.com.fiap.parquimetro.infraestructure.gateway.dto.RequestGeraCobrancaDebito;
import br.com.fiap.parquimetro.infraestructure.gateway.model.Beneficiario;
import br.com.fiap.parquimetro.infraestructure.gateway.model.Pagador;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestGeraCobrancaDebitoBuilder {

    private RequestGeraCobrancaDebito requestGeraCobrancaDebito;

    public RequestGeraCobrancaDebitoBuilder() {
        this.requestGeraCobrancaDebito = new RequestGeraCobrancaDebito();
        this.requestGeraCobrancaDebito.setBeneficiario(new Beneficiario());
    }

    public RequestGeraCobrancaDebitoBuilder withBeneficiario (Beneficiario beneficiario){
        this.requestGeraCobrancaDebito.setBeneficiario(beneficiario);
        return this;
    }
    public RequestGeraCobrancaDebitoBuilder withPagador (Pagador pagador){
        this.requestGeraCobrancaDebito.setPagador(pagador);
        return this;

    }
    public RequestGeraCobrancaDebitoBuilder withSeuNumero (String seuNumero){
        this.requestGeraCobrancaDebito.setSeuNumero(seuNumero);
        return this;

    }
    public RequestGeraCobrancaDebitoBuilder withLocalDate (LocalDate dataCobranca){
        this.requestGeraCobrancaDebito.setDataCobranca(dataCobranca);
        return this;

    }
    public RequestGeraCobrancaDebitoBuilder withBigDecimal (BigDecimal valor){
        this.requestGeraCobrancaDebito.setValor(valor);
        return this;

    }

    public RequestGeraCobrancaDebito build() {
        return this.requestGeraCobrancaDebito;
    }


}
