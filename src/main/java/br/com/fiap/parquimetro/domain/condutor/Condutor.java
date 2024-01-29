package br.com.fiap.parquimetro.domain.condutor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condutor {

    String uuid;
    String nome;
    String email;
    String senha;
    String cpf;
    FormaPagamentoEnum formaPagamentoPadrao;
    Endereco endereco;
    List<Veiculo> veiculo;

    public Condutor(
            String nome,
            String email,
            String cpf,
            String senha,
            FormaPagamentoEnum formaPagamentoPadrao,
            Endereco endereco,
            List<Veiculo> veiculo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.formaPagamentoPadrao = formaPagamentoPadrao;
        this.endereco = endereco;
        this.veiculo = veiculo;
    }
}
