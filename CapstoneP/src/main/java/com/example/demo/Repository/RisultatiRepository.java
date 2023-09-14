package com.example.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Risultati;

@Repository
public interface RisultatiRepository extends JpaRepository<Risultati, UUID> {

}
