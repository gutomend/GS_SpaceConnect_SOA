package br.com.fiap.ares.service;

import br.com.fiap.ares.dto.AlertaDTO;
import br.com.fiap.ares.entity.Rover;
import br.com.fiap.ares.entity.Telemetria;

import java.util.List;

public interface AlertaService {

    void analisarTelemetria(
            Telemetria telemetria,
            Rover rover);

    List<AlertaDTO> listarTodos();
}