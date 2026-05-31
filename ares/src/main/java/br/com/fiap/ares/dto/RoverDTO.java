package br.com.fiap.ares.dto;

import br.com.fiap.ares.enums.StatusRover;

public record RoverDTO(

        String nome,

        String modelo,

        Double nivelBateria,

        StatusRover status,

        Double latitude,

        Double longitude

) {
}