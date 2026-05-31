package br.com.fiap.ares.service.impl;

import br.com.fiap.ares.dto.AlertaDTO;
import br.com.fiap.ares.entity.Alerta;
import br.com.fiap.ares.entity.Rover;
import br.com.fiap.ares.entity.Telemetria;
import br.com.fiap.ares.enums.NivelAlerta;
import br.com.fiap.ares.repository.AlertaRepository;
import br.com.fiap.ares.service.AlertaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaServiceImpl
        implements AlertaService {

    private final AlertaRepository alertaRepository;

    @Override
    public void analisarTelemetria(
            Telemetria telemetria,
            Rover rover) {

        if (telemetria.getTemperatura() > 80) {

            Alerta alerta = Alerta.builder()
                    .descricao("Temperatura crítica detectada")
                    .nivel(NivelAlerta.CRITICO)
                    .dataGeracao(LocalDateTime.now())
                    .rover(rover)
                    .build();

            alertaRepository.save(alerta);
        }

        if (telemetria.getRadiacao() > 7) {

            Alerta alerta = Alerta.builder()
                    .descricao("Nível elevado de radiação")
                    .nivel(NivelAlerta.ALTO)
                    .dataGeracao(LocalDateTime.now())
                    .rover(rover)
                    .build();

            alertaRepository.save(alerta);
        }

        if (telemetria.getVelocidade() > 40) {

            Alerta alerta = Alerta.builder()
                    .descricao("Velocidade acima do recomendado")
                    .nivel(NivelAlerta.MEDIO)
                    .dataGeracao(LocalDateTime.now())
                    .rover(rover)
                    .build();

            alertaRepository.save(alerta);
        }
    }

    @Override
    public List<AlertaDTO> listarTodos() {

        return alertaRepository.findAll()
                .stream()
                .map(alerta -> new AlertaDTO(
                        alerta.getDescricao(),
                        alerta.getNivel(),
                        alerta.getRover().getId()
                ))
                .toList();
    }
}