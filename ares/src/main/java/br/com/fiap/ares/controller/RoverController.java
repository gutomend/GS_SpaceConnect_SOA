package br.com.fiap.ares.controller;

import br.com.fiap.ares.dto.RoverDTO;
import br.com.fiap.ares.service.RoverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rovers")
@RequiredArgsConstructor
public class RoverController {

    private final RoverService roverService;

    @PostMapping
    public RoverDTO cadastrar(
            @RequestBody RoverDTO dto) {

        return roverService.cadastrar(dto);
    }

    @GetMapping
    public List<RoverDTO> listarTodos() {

        return roverService.listarTodos();
    }

    @GetMapping("/{id}")
    public RoverDTO buscarPorId(
            @PathVariable Long id) {

        return roverService.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public RoverDTO atualizar(
            @PathVariable Long id,
            @RequestBody RoverDTO dto) {

        return roverService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id) {

        roverService.deletar(id);
    }
}