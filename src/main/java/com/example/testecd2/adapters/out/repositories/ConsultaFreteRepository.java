package com.example.testecd2.adapters.out.repositories;

import com.example.testecd2.adapters.out.entities.ConsultaFreteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaFreteRepository extends JpaRepository<ConsultaFreteEntity, Long> {

}
