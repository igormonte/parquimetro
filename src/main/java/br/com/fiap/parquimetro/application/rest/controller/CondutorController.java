package br.com.fiap.parquimetro.application.rest.controller;

import br.com.fiap.parquimetro.application.rest.dto.request.RequestCondutorDto;
import br.com.fiap.parquimetro.application.rest.dto.response.ResponseCondutorDto;
import br.com.fiap.parquimetro.domain.condutor.repository.ConsultaCondutor;
import br.com.fiap.parquimetro.domain.condutor.repository.RegistrarCondutor;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.CondutorMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condutor")
public class CondutorController {

    private RegistrarCondutor registrarCondutor;

    private ConsultaCondutor consultaCondutor;
    private CondutorMapper condutorMapper;

    public CondutorController(RegistrarCondutor registrarCondutor,
                              CondutorMapper condutorMapper) {
        this.registrarCondutor = registrarCondutor;
        this.condutorMapper = condutorMapper;
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseCondutorDto> ConsultaCondutor(@PathVariable String uuid) {
        ResponseCondutorDto condutorDto = ResponseCondutorDto
                .from(this.consultaCondutor.findById(uuid).orElseThrow());
        return ResponseEntity.ok(condutorDto);
    }

    @PostMapping()
    public ResponseEntity<ResponseCondutorDto> registrarCondutor(@Valid @RequestBody RequestCondutorDto condutor) {
        ResponseCondutorDto condutorDto = ResponseCondutorDto
                .from(this.registrarCondutor.executar(
                        this.condutorMapper.map(condutor)));
        return ResponseEntity.ok(condutorDto);
    }

}
