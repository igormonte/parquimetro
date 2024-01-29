package br.com.fiap.parquimetro.infraestructure.postgre.service;

import br.com.fiap.parquimetro.domain.condutor.Condutor;
import br.com.fiap.parquimetro.domain.condutor.Endereco;
import br.com.fiap.parquimetro.domain.condutor.Veiculo;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.EnderecoEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.VeiculoEntity;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.CondutorMapper;
import br.com.fiap.parquimetro.infraestructure.postgre.entity.CondutorEntity;
import br.com.fiap.parquimetro.infraestructure.postgre.repository.CondutorRepository;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.EnderecoMapper;
import br.com.fiap.parquimetro.infraestructure.utils.mapper.VeiculoMapper;
import jakarta.transaction.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CondutorServiceImpl implements CondutorService {

    private CondutorRepository condutorRepository;
    private CondutorMapper condutorMapper;
    private EnderecoService enderecoService;
    private EnderecoMapper enderecoMapper;
    private VeiculoService veiculoService;
    private VeiculoMapper veiculoMapper;

    public CondutorServiceImpl(
            CondutorRepository condutorRepository,
            CondutorMapper condutorMapper,
            EnderecoService enderecoService,
            EnderecoMapper enderecoMapper,
            VeiculoService veiculoService,
            VeiculoMapper veiculoMapper
    ) {
        this.condutorRepository = condutorRepository;
        this.condutorMapper = condutorMapper;
        this.enderecoService = enderecoService;
        this.enderecoMapper = enderecoMapper;
        this.veiculoService = veiculoService;
        this.veiculoMapper = veiculoMapper;
    }

    @Override
    @Transactional
    public Condutor save(Condutor condutor) {
        EnderecoEntity enderecoSalvo = this.saveEndereco(condutor.getEndereco());
        CondutorEntity condutorEntity = this.condutorMapper.map(condutor);
        condutorEntity.setEndereco(enderecoSalvo);

        CondutorEntity condutorSalvo =
                this.condutorRepository.save(condutorEntity);

        List<VeiculoEntity> veiculos = this.saveVeiculos(
                condutorSalvo.getUuid().toString(), condutor.getVeiculo()
        );

        condutorSalvo.setVeiculo(veiculos);

        return this.condutorMapper.map(condutorSalvo);
    }

    @Override
    @Transactional
    public Condutor update(Condutor condutor) {
        return this.condutorMapper.map(this.condutorRepository.save(this.condutorMapper.map(condutor)));
    }

    @Override
    public Optional<Condutor> findById(UUID uuid) {
        Optional<CondutorEntity> condutorEntity = this.condutorRepository.findById(uuid);
        return condutorEntity.map(entity -> this.condutorMapper.map(entity));

    }

    @Override
    public Optional<Condutor> findByCpf(String cpf) {
        Optional<CondutorEntity> condutorEntity = this.condutorRepository.findByCpf(cpf);
        return condutorEntity.map(entity -> this.condutorMapper.map(entity));
    }

    private EnderecoEntity saveEndereco(Endereco endereco) {
        return this.enderecoService.save(
                this.enderecoMapper.map(endereco)
        );
    }

    private List<VeiculoEntity> saveVeiculos(String uuidCondutor, List<Veiculo> veiculos) {
        List<VeiculoEntity> veiculosSalvos = new LinkedList<>();

        veiculos.forEach(v->{
                VeiculoEntity veiculo = this.veiculoMapper.map(uuidCondutor, v);
                VeiculoEntity veiculoSalvo = this.veiculoService.save(veiculo);
                veiculosSalvos.add(veiculoSalvo);
            }
        );

        return veiculosSalvos;
    }


}
