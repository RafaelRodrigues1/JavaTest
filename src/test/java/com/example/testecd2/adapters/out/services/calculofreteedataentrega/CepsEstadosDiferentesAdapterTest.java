package com.example.testecd2.adapters.out.services.calculofreteedataentrega;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CepsEstadosDiferentesAdapterTest {

    @InjectMocks
    CepsEstadosDiferentesAdapter cepsEstadosDiferentesAdapter;


    @Test
    void calculaFreteWithValidData() {
        assertEquals(100, cepsEstadosDiferentesAdapter.calculaFrete(100.0));
        assertEquals(52, cepsEstadosDiferentesAdapter.calculaFrete(52.0));
        assertEquals(58.5, cepsEstadosDiferentesAdapter.calculaFrete(58.5));
    }

    @Test
    void calculaFreteWithInvalidData() {
        assertThrows(NullPointerException.class, () -> cepsEstadosDiferentesAdapter.calculaFrete(null));
    }
}
