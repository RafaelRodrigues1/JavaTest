package com.example.testecd2.adapters.out.services.calculofreteedataentrega;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CepsDDDsIguaisAdapterTest {

    @InjectMocks
    CepsDDDsIguaisAdapter cepsDDDsIguaisAdapter;


    @Test
    void calculaFreteWithValidData() {
        assertEquals(50, cepsDDDsIguaisAdapter.calculaFrete(100.0));
        assertEquals(26, cepsDDDsIguaisAdapter.calculaFrete(52.0));
        assertEquals(29.25, cepsDDDsIguaisAdapter.calculaFrete(58.5));
    }

    @Test
    void calculaFreteWithInvalidData() {
        assertThrows(NullPointerException.class, () -> cepsDDDsIguaisAdapter.calculaFrete(null));
    }
}
