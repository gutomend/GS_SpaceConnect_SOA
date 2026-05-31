package br.com.fiap.ares.repository;

import br.com.fiap.ares.entity.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetriaRepository
        extends JpaRepository<Telemetria, Long> {
}