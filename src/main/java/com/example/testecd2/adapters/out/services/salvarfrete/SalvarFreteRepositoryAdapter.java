package com.example.testecd2.adapters.out.services.salvarfrete;

import com.example.testecd2.adapters.out.entities.ConsultaFreteEntity;
import com.example.testecd2.adapters.out.mappers.ConsultaFreteEntityMapper;
import com.example.testecd2.adapters.out.repositories.ConsultaFreteRepository;
import com.example.testecd2.core.models.ConsultaFrete;
import com.example.testecd2.core.usecases.interfaces.SalvarConsultaFretePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarFreteRepositoryAdapter implements SalvarConsultaFretePort {

    @Autowired
    private ConsultaFreteRepository consultaFreteRepository;
    private final ConsultaFreteEntityMapper consultaFreteEntityMapper = ConsultaFreteEntityMapper.INSTANCE;

    @Override
    public ConsultaFrete salvarConsultaFrete(ConsultaFrete consultaFrete) {
        ConsultaFreteEntity consultaFreteEntity = consultaFreteEntityMapper.toModel(consultaFrete);
        consultaFreteRepository.save(consultaFreteEntity);
        return consultaFrete;
    }
}
