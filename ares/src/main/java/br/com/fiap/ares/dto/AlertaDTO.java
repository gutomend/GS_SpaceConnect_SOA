package br.com.fiap.ares.dto;

import br.com.fiap.ares.enums.NivelAlerta;

public record AlertaDTO(

        String descricao,

        NivelAlerta nivel,

        Long roverId

) {
}