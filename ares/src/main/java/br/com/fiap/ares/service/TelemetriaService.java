package br.com.fiap.ares.service;

import br.com.fiap.ares.dto.TelemetriaDTO;

import java.util.List;

public interface TelemetriaService {

    TelemetriaDTO cadastrar(TelemetriaDTO dto);

    List<TelemetriaDTO> listarTodas();
}