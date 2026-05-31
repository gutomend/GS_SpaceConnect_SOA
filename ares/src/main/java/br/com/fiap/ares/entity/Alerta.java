package br.com.fiap.ares.entity;

import br.com.fiap.ares.enums.NivelAlerta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALERTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private NivelAlerta nivel;

    private LocalDateTime dataGeracao;

    @ManyToOne
    @JoinColumn(name = "rover_id")
    private Rover rover;
}