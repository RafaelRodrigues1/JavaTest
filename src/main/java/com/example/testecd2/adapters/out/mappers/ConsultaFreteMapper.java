package com.example.testecd2.adapters.out.mappers;

import com.example.testecd2.adapters.dto.ConsultaFreteRequest;
import com.example.testecd2.core.models.ConsultaFrete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.testecd2.adapters.dto.ConsultaFreteResponse;

@Mapper
public interface ConsultaFreteMapper {

	ConsultaFreteMapper INSTANCE = Mappers.getMapper(ConsultaFreteMapper.class);

	ConsultaFrete toModel(ConsultaFreteRequest consultaFrete);
	
	@Mapping(target = "dataPrevistaEntrega", source = "dataPrevistaEntrega", dateFormat = "dd/MM/yyyy")
	ConsultaFreteResponse toDTO(ConsultaFrete consultaFrete);
}
