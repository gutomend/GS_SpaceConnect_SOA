package br.com.fiap.ares.repository;

import br.com.fiap.ares.entity.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository
        extends JpaRepository<Rover, Long> {
}