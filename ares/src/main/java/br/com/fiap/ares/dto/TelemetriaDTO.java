package br.com.fiap.ares.dto;

public record TelemetriaDTO(

        Double temperatura,

        Double radiacao,

        Double velocidade,

        Long roverId

) {
}