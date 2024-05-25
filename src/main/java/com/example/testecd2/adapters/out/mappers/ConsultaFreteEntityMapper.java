package com.example.testecd2.adapters.out.mappers;

import com.example.testecd2.adapters.out.entities.ConsultaFreteEntity;
import com.example.testecd2.core.models.ConsultaFrete;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultaFreteEntityMapper {

    ConsultaFreteEntityMapper INSTANCE = Mappers.getMapper(ConsultaFreteEntityMapper.class);

    ConsultaFreteEntity toModel(ConsultaFrete consultaFrete);
}
