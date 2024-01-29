package br.com.fiap.parquimetro.infraestructure.postgre.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @Column
    String rua;

    @Column
    Integer numero;

    @Column
    String bairro;

    @Column
    String cidade;

    @Column(length = 2)
    String uf;

    @Column
    String cep;

}
