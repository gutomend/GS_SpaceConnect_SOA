package br.com.fiap.ares.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TELEMETRIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Telemetria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;

    private Double radiacao;

    private Double velocidade;

    private LocalDateTime dataRegistro;

    @ManyToOne
    @JoinColumn(name = "rover_id")
    private Rover rover;
}