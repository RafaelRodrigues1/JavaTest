package com.example.testecd2.adapters.out.services.calculofreteedataentrega;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CepsEstadosIguaisAdapterTest {

    @InjectMocks
    CepsEstadosIguaisAdapter cepsEstadosIguaisAdapter;


    @Test
    void calculaFreteWithValidData() {
        assertEquals(25, cepsEstadosIguaisAdapter.calculaFrete(100.0));
        assertEquals(13, cepsEstadosIguaisAdapter.calculaFrete(52.0));
        assertEquals(14.625, cepsEstadosIguaisAdapter.calculaFrete(58.5));
    }

    @Test
    void calculaFreteWithInvalidData() {
        assertThrows(NullPointerException.class, () -> cepsEstadosIguaisAdapter.calculaFrete(null));
    }
}
