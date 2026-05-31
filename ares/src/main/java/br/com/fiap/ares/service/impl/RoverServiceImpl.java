package br.com.fiap.ares.service.impl;

import br.com.fiap.ares.dto.RoverDTO;
import br.com.fiap.ares.entity.Rover;
import br.com.fiap.ares.exception.RoverNotFoundException;
import br.com.fiap.ares.repository.RoverRepository;
import br.com.fiap.ares.service.RoverService;
import br.com.fiap.ares.vo.Coordenada;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoverServiceImpl implements RoverService {

    private final RoverRepository repository;

    @Override
    public RoverDTO cadastrar(RoverDTO dto) {

        Rover rover = Rover.builder()
                .nome(dto.nome())
                .modelo(dto.modelo())
                .nivelBateria(dto.nivelBateria())
                .status(dto.status())
                .ultimaComunicacao(LocalDateTime.now())
                .coordenada(
                        new Coordenada(
                                dto.latitude(),
                                dto.longitude()
                        )
                )
                .build();

        repository.save(rover);

        return dto;
    }

    @Override
    public List<RoverDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(rover -> new RoverDTO(
                        rover.getNome(),
                        rover.getModelo(),
                        rover.getNivelBateria(),
                        rover.getStatus(),
                        rover.getCoordenada().getLatitude(),
                        rover.getCoordenada().getLongitude()
                ))
                .toList();
    }

    @Override
    public RoverDTO buscarPorId(Long id) {

        Rover rover = repository.findById(id)
                .orElseThrow(() ->
                        new RoverNotFoundException(
                                "Rover não encontrado"));

        return new RoverDTO(
                rover.getNome(),
                rover.getModelo(),
                rover.getNivelBateria(),
                rover.getStatus(),
                rover.getCoordenada().getLatitude(),
                rover.getCoordenada().getLongitude()
        );
    }
    @Override
    public RoverDTO atualizar(Long id, RoverDTO dto) {

        Rover rover = repository.findById(id)
                .orElseThrow(() ->
                        new RoverNotFoundException(
                                "Rover não encontrado"));

        rover.setNome(dto.nome());
        rover.setModelo(dto.modelo());
        rover.setNivelBateria(dto.nivelBateria());
        rover.setStatus(dto.status());

        repository.save(rover);

        return dto;
    }

    @Override
    public void deletar(Long id) {

        Rover rover = repository.findById(id)
                .orElseThrow(() ->
                        new RoverNotFoundException(
                                "Rover não encontrado"));

        repository.delete(rover);
    }
}