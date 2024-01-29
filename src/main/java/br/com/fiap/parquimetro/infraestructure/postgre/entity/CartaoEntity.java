package br.com.fiap.parquimetro.infraestructure.postgre.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "cartao")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    private String numeroCartao;

    @Column
    private String nomeTitular;

    @Column(length = 5)
    private String cvv;

}
