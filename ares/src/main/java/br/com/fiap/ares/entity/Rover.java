package br.com.fiap.ares.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.*;

import br.com.fiap.ares.enums.StatusRover;
import br.com.fiap.ares.vo.Coordenada;
import jakarta.persistence.*;


import java.time.LocalDateTime;

import java.util.List;

@Entity
@Table(name = "TB_ROVER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String modelo;

    private Double nivelBateria;

    @Enumerated(EnumType.STRING)
    private StatusRover status;

    private LocalDateTime ultimaComunicacao;

    @Embedded
    private Coordenada coordenada;

    @OneToMany(mappedBy = "rover")
    private List<Telemetria> telemetrias;

    @OneToMany(mappedBy = "rover")
    private List<Alerta> alertas;
}
