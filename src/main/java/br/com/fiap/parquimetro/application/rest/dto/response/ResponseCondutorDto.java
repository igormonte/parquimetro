package br.com.fiap.parquimetro.application.rest.dto.response;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.FormaPagamentoEnum;
import br.com.fiap.parquimetro.domain.condutor.Endereco;

import java.util.List;

public record ResponseCondutorDto(

    String uuid,
    String nome,
    String email,
    String cpf,
    FormaPagamentoEnum formaPagamentoPadrao,
    Endereco endereco,
    List<ResponseVeiculoDto> veiculos

){

    public static ResponseCondutorDto from(Condutor condutor) {
        return new ResponseCondutorDto(
                condutor.getUuid(),
                condutor.getNome(),
                condutor.getEmail(),
                condutor.getCpf(),
                condutor.getFormaPagamentoPadrao(),
                condutor.getEndereco(),
                ResponseVeiculoDto.fromEntityList(condutor.getVeiculo()));
    }

}
