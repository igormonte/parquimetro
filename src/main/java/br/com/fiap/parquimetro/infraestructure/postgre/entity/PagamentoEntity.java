package br.com.fiap.parquimetro.infraestructure.postgre.entity;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.estacionamento.Cartao;
import br.com.fiap.parquimetro.domain.estacionamento.StatusPagamentoEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    private BigDecimal valor;

    @Column
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataPagamento;

    @Column
    private FormaPagamentoEnum formaPagamento;

    @Column
    private StatusPagamentoEnum statusPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuidCartao", referencedColumnName = "uuid")
    private CartaoEntity cartao;


}
