package com.example.testecd2.adapters.in.controllers;

import com.example.testecd2.adapters.dto.ConsultaFreteRequest;
import com.example.testecd2.adapters.dto.ConsultaFreteResponse;
import com.example.testecd2.adapters.out.services.ConsultaFreteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

@ExtendWith(MockitoExtension.class)
class ConsultaFreteControllerTest {

    @InjectMocks
    ConsultaFreteController consultaFreteController;

    @Mock
    ConsultaFreteService consultaFreteService;

    private MockMvc mockMvc;

    private String url;
    private ConsultaFreteRequest consultaFreteRequest;

    private ConsultaFreteResponse consultaFreteResponse;

    private String jsonRequest;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(consultaFreteController).alwaysDo(print()).build();
        url = "/frete";
        consultaFreteRequest = ConsultaFreteRequest.builder()
                .cepOrigem("51200-110")
                .cepDestino("56505-025")
                .nomeDestinatario("Rafa")
                .peso(100.0)
                .build();
        jsonRequest = objectMapper.writeValueAsString(consultaFreteRequest);
        consultaFreteResponse = ConsultaFreteResponse.builder()
                .vlTotalFrete(50.0)
                .dataPrevistaEntrega("27/10/1994")
                .cepOrigem("51200-110")
                .cepDestino("56505-025")
                .build();
    }

    @Test
    void getFreteWithValidData() throws Exception {
        when(consultaFreteService.getFrete(consultaFreteRequest)).thenReturn(consultaFreteResponse);

        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        verify(consultaFreteService).getFrete(consultaFreteRequest);
        verifyNoMoreInteractions(consultaFreteService);
    }

    @Test
    void returnBadRequestIfWithoutRequestData() throws Exception {

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(consultaFreteService);
    }

    @Test
    void returnBadRequestIfServiceError() throws Exception {
        doThrow(new RuntimeException()).when(consultaFreteService).getFrete(consultaFreteRequest);

        assertThrows(NestedServletException.class, () -> mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()));

        verify(consultaFreteService).getFrete(consultaFreteRequest);
        verifyNoMoreInteractions(consultaFreteService);
    }
}
