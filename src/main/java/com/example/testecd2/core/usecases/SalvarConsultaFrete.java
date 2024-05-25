package com.example.testecd2.core.usecases;

import com.example.testecd2.core.models.ConsultaFrete;
import com.example.testecd2.core.usecases.interfaces.CalculoPort;
import com.example.testecd2.core.usecases.interfaces.SalvarConsultaFretePort;

import java.time.LocalDate;

public class SalvarConsultaFrete {

    private SalvarConsultaFretePort salvarConsultaFrete;
    private CalculoPort calculo;

    public SalvarConsultaFrete(SalvarConsultaFretePort salvarConsultaFrete) {
        this.salvarConsultaFrete = salvarConsultaFrete;
    }

    public ConsultaFrete execute(ConsultaFrete consultaFrete) {
        if(calculo == null)
            throw new ClassCastException("Cálculo não implementado!");
        consultaFrete.setVlTotalFrete(calculo.calculaFrete(consultaFrete.getPeso()));
        consultaFrete.setDataConsulta(LocalDate.now());
        consultaFrete.setDataPrevistaEntrega(calculo.calculaDataEntrega());
        return salvarConsultaFrete.salvarConsultaFrete(consultaFrete);
    }

    public void setCalculo(CalculoPort calculo) {
        this.calculo = calculo;
    }
}
