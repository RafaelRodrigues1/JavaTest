package com.example.testecd2.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.testecd2.dto.ConsultaFreteRequest;
import com.example.testecd2.dto.ConsultaFreteResponse;
import com.example.testecd2.entities.ConsultaFrete;

@Mapper
public interface ConsultaFreteMapper {

	ConsultaFreteMapper INSTANCE = Mappers.getMapper(ConsultaFreteMapper.class);
	
	ConsultaFrete toModel(ConsultaFreteRequest consultaFrete);
	
	@Mapping(target = "dataPrevistaEntrega", source = "dataPrevistaEntrega", dateFormat = "dd/MM/yyyy")
	ConsultaFreteResponse toDTO(ConsultaFrete person);
}
