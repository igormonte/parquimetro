package br.com.fiap.parquimetro.infraestructure.postgre.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @Column
    String placa;

    @Column
    String nome;

    @Column
    Boolean inativo;

    @ManyToOne()
    @JoinColumn(name = "uuidCondutor", referencedColumnName = "uuid")
    private CondutorEntity condutor;


}
