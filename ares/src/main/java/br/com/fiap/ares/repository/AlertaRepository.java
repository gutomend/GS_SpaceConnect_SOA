package br.com.fiap.ares.repository;

import br.com.fiap.ares.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository
        extends JpaRepository<Alerta, Long> {
}