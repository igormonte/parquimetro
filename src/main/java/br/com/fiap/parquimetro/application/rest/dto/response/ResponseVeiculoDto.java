package br.com.fiap.parquimetro.application.rest.dto.response;

import br.com.fiap.parquimetro.domain.condutor.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public record ResponseVeiculoDto(

    String uuid,

    String placa,

    String nome,

    Boolean inativo

){

    public static ResponseVeiculoDto fromEntity(Veiculo veiculo) {
        return new ResponseVeiculoDto(
                veiculo.getUuid(),
                veiculo.getPlaca(),
                veiculo.getNome(),
                veiculo.getInativo());
    }
    public static List<ResponseVeiculoDto> fromEntityList(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(ResponseVeiculoDto::fromEntity)
                .collect(Collectors.toList());
    }
}
