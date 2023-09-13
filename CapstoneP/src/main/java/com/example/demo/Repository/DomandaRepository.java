package com.example.demo.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Level.Level;
import com.example.demo.entities.Domanda;

@Repository
public interface DomandaRepository extends JpaRepository<Domanda, UUID> {

	List<Domanda> findByLevel(Level level);

}
