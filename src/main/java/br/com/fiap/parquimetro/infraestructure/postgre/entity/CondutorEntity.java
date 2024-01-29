package br.com.fiap.parquimetro.infraestructure.postgre.entity;

import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "condutor")
public class CondutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @Column
    String nome;

    @Column
    String email;

    @Column
    String senha;

    @Column
    String cpf;

    @Column
    FormaPagamentoEnum formaPagamentoPadrao;

    @OneToOne()
    @JoinColumn(name = "uuidEndereco", referencedColumnName = "uuid")
    EnderecoEntity endereco;

    @OneToMany(mappedBy = "condutor", fetch = FetchType.EAGER)
    List<VeiculoEntity> veiculo;
}
