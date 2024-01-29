package br.com.fiap.parquimetro.infraestructure.postgre.entity;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.domain.estacionamento.Pagamento;
import br.com.fiap.parquimetro.domain.estacionamento.PeriodoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.StatusEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Valor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "estacionamento")
public class EstacionamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    private PeriodoEnum periodo;

    @Column
    private Long tempo;

    @Column
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataPrevisaoSaida;

    @Column
    private LocalDateTime dataFinalizacao;

    @ManyToOne()
    @JoinColumn(name = "uuidCondutor", referencedColumnName = "uuid")
    private CondutorEntity condutor;

    @ManyToOne
    @JoinColumn(name = "uuidVeiculo", referencedColumnName = "uuid")
    private VeiculoEntity veiculo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuidPagamento", referencedColumnName = "uuid")
    private PagamentoEntity pagamento;

    @Column
    private StatusEnum status;

    @Column
    private BigDecimal valor;
}

