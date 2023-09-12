package com.example.demo.Repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Level.Level;
import com.example.demo.entities.Domanda;

@Repository
public interface DomandaRepository extends JpaRepository<Domanda, UUID> {

	Page<Domanda> findByLevel(Level level, Pageable pageable);

}
