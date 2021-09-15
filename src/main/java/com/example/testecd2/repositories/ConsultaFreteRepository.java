package com.example.testecd2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testecd2.entities.ConsultaFrete;

@Repository
public interface ConsultaFreteRepository extends JpaRepository<ConsultaFrete, Long> {

}
