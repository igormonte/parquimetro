package br.com.fiap.parquimetro.application.rest.controller;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestEstacionamentoDto;
import br.com.fiap.parquimetro.application.rest.dto.request.RequestFinalizacaoEstacionamentoDto;
import br.com.fiap.parquimetro.application.rest.dto.response.ResponseEstacionamentoDto;
import br.com.fiap.parquimetro.domain.estacionamento.Estacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.ConsultaEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.FinalizarEstacionamento;
import br.com.fiap.parquimetro.domain.estacionamento.repository.RegistrarEstacionamento;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.EstacionamentoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    private RegistrarEstacionamento registrarEstacionamento;
    private FinalizarEstacionamento finalizarEstacionamento;
    private ConsultaEstacionamento consultaEstacionamento;
    private EstacionamentoMapper estacionamentoMapper;

    public EstacionamentoController(
            RegistrarEstacionamento registrarEstacionamento,
            FinalizarEstacionamento finalizarEstacionamento,
            ConsultaEstacionamento consultaEstacionamento,
            EstacionamentoMapper estacionamentoMapper) {
        this.registrarEstacionamento = registrarEstacionamento;
        this.consultaEstacionamento = consultaEstacionamento;
        this.finalizarEstacionamento = finalizarEstacionamento;
        this.estacionamentoMapper = estacionamentoMapper;
    }

    @PostMapping()
    public ResponseEntity<ResponseEstacionamentoDto> registrarEstacionamento(@Valid @RequestBody RequestEstacionamentoDto estacionamentoDto) {
        ResponseEstacionamentoDto condutorDto = ResponseEstacionamentoDto
                .from(this.registrarEstacionamento.executar(
                        this.estacionamentoMapper.map(estacionamentoDto)));
        return ResponseEntity.ok(condutorDto);
    }

    @PostMapping("finalizar")
    public ResponseEntity<String> finalizarEstacionamento(
            @Valid @RequestBody RequestFinalizacaoEstacionamentoDto requestFinalizacaoEstacionamentoDto) {
        Boolean resultado =
                this.finalizarEstacionamento.executar(requestFinalizacaoEstacionamentoDto.uuid());
        if(resultado) {
            return ResponseEntity.ok("Estacionamento Finalizado com Sucesso!");
        }
        return ResponseEntity.status(400).body("");
    }

    @GetMapping("condutor/{uuid}")
    public ResponseEntity<List<ResponseEstacionamentoDto>> consultaPorCondutor(@PathVariable String uuid) {

        List<Estacionamento> estacionamentos = this.consultaEstacionamento.findByCondutorUuid(uuid);

        List<ResponseEstacionamentoDto> condutorDto =
                estacionamentos.stream().map(
                        ResponseEstacionamentoDto::from
                ).collect(Collectors.toList());

        return ResponseEntity.ok(condutorDto);
    }

}
