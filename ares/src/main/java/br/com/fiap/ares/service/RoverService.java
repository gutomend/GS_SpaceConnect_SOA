package br.com.fiap.ares.service;

import br.com.fiap.ares.dto.RoverDTO;

import java.util.List;

public interface RoverService {

    RoverDTO cadastrar(RoverDTO dto);

    List<RoverDTO> listarTodos();

    RoverDTO buscarPorId(Long id);

    RoverDTO atualizar(Long id, RoverDTO dto);

    void deletar(Long id);
}