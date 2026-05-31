package br.com.fiap.ares.controller;

import br.com.fiap.ares.dto.TelemetriaDTO;
import br.com.fiap.ares.service.TelemetriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telemetrias")
@RequiredArgsConstructor
public class TelemetriaController {

    private final TelemetriaService telemetriaService;

    @PostMapping
    public TelemetriaDTO cadastrar(
            @RequestBody TelemetriaDTO dto) {

        return telemetriaService.cadastrar(dto);
    }

    @GetMapping
    public List<TelemetriaDTO> listarTodas() {

        return telemetriaService.listarTodas();
    }
}