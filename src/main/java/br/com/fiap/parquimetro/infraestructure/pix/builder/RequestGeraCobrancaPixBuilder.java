package br.com.fiap.parquimetro.infraestructure.pix.builder;

import br.com.fiap.parquimetro.infraestructure.pix.dto.RequestGeraCobrancaPix;
import br.com.fiap.parquimetro.infraestructure.pix.model.Beneficiario;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestGeraCobrancaPixBuilder {

    private RequestGeraCobrancaPix requestGeraCobrancaPix;

    public RequestGeraCobrancaPixBuilder() {
        this.requestGeraCobrancaPix = new RequestGeraCobrancaPix();
        this.requestGeraCobrancaPix.setBeneficiario(new Beneficiario());
    }

    public RequestGeraCobrancaPixBuilder withSeuNumero (String seuNumero){
        this.requestGeraCobrancaPix.setSeuNumero(seuNumero);
        return this;

    }
    public RequestGeraCobrancaPixBuilder withLocalDate (LocalDate dataCobranca){
        this.requestGeraCobrancaPix.setDataCobranca(dataCobranca);
        return this;

    }
    public RequestGeraCobrancaPixBuilder withBigDecimal (BigDecimal valor){
        this.requestGeraCobrancaPix.setValor(valor);
        return this;

    }

    public RequestGeraCobrancaPix build() {
        return this.requestGeraCobrancaPix;
    }

}
