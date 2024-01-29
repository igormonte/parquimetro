package br.com.fiap.parquimetro.domain.estacionamento;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.estacionamento.exception.TaxaDeCobrancaNaoCadastradaException;
import br.com.fiap.parquimetro.domain.estacionamento.exception.TempoPermanenciaNaoInformadoException;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Data
public class Estacionamento {

    private String uuid;

    private PeriodoEnum periodo;

    private Long tempo;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataPrevisaoSaida;

    private LocalDateTime dataFinalizacao;

    private Condutor condutor;

    private Veiculo veiculo;

    private StatusEnum status;

    private Pagamento pagamento;

    private Valor valor;

    public Boolean isPeriodoFixo() {
        return this.periodo.equals(PeriodoEnum.FIXO);
    }

    public Boolean isPeriodoVariavel() {
        return this.periodo.equals(PeriodoEnum.VARIAVEL);
    }

    public Boolean isQuitado() {

        if(pagamento == null || pagamento.getStatusPagamento() == null) {
            return false;
        }

        return pagamento.getStatusPagamento().equals(StatusPagamentoEnum.QUITADO);

    }

    public Boolean isEmProgresso() {
        return this.status.equals(StatusEnum.EM_PROGRESSO);
    }
    public Boolean isEncerrado() {
        return this.isQuitado() && this.status.equals(StatusEnum.ENCERRADO);
    }

    public Boolean isExpirado() {
        return this.dataPrevisaoSaida.isBefore(LocalDateTime.now());
    }

    public void calculaDataPreviaSaida() {
        this.dataPrevisaoSaida = this.dataCriacao.plusHours(this.tempo);
    }

    public void calculaValorPeriodoFixo() {

        if(this.tempo == null) {
            throw new TempoPermanenciaNaoInformadoException();
        }

        this.valor = new Valor();
        this.valor.calculaCobranca(this.tempo);
    }

    public void calculaValorPeriodoVariavel() {

        long minutos = ChronoUnit.MINUTES.between(this.dataCriacao, this.dataFinalizacao);

        Double horasDouble = Math.ceil(Double.valueOf(minutos) / 60);

        long horas = horasDouble.intValue();
        this.tempo = horas;
        this.valor = new Valor();
        this.valor.calculaCobranca(horas);

    }

}

