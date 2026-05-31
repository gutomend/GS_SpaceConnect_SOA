package br.com.fiap.ares.controller;

import br.com.fiap.ares.dto.AlertaDTO;
import br.com.fiap.ares.service.AlertaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService alertaService;

    @GetMapping
    public List<AlertaDTO> listarTodos() {

        return alertaService.listarTodos();
    }
}