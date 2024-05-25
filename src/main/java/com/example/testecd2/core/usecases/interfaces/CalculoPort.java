package com.example.testecd2.core.usecases.interfaces;

import java.time.LocalDate;

public interface CalculoPort {

    double calculaFrete(Double peso);
    double calculaDesconto();
    LocalDate calculaDataEntrega();
}
