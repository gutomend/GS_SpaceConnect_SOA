package br.com.fiap.ares.service.impl;

import br.com.fiap.ares.dto.TelemetriaDTO;
import br.com.fiap.ares.entity.Rover;
import br.com.fiap.ares.entity.Telemetria;
import br.com.fiap.ares.exception.RoverNotFoundException;
import br.com.fiap.ares.repository.RoverRepository;
import br.com.fiap.ares.repository.TelemetriaRepository;
import br.com.fiap.ares.service.AlertaService;
import br.com.fiap.ares.service.TelemetriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelemetriaServiceImpl
        implements TelemetriaService {

    private final TelemetriaRepository telemetriaRepository;
    private final RoverRepository roverRepository;
    private final AlertaService alertaService;

    @Override
    public TelemetriaDTO cadastrar(
            TelemetriaDTO dto) {

        Rover rover = roverRepository.findById(dto.roverId())
                .orElseThrow(() ->
                        new RoverNotFoundException(
                                "Rover não encontrado"));

        Telemetria telemetria = Telemetria.builder()
                .temperatura(dto.temperatura())
                .radiacao(dto.radiacao())
                .velocidade(dto.velocidade())
                .dataRegistro(LocalDateTime.now())
                .rover(rover)
                .build();

        telemetriaRepository.save(telemetria);
        alertaService.analisarTelemetria(
                telemetria,
                rover
        );
        return dto;
    }

    @Override
    public List<TelemetriaDTO> listarTodas() {

        return telemetriaRepository.findAll()
                .stream()
                .map(t -> new TelemetriaDTO(
                        t.getTemperatura(),
                        t.getRadiacao(),
                        t.getVelocidade(),
                        t.getRover().getId()
                ))
                .toList();
    }
}