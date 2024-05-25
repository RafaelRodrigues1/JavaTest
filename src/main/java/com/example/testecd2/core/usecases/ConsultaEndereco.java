package com.example.testecd2.core.usecases;

import com.example.testecd2.core.models.Endereco;
import com.example.testecd2.core.usecases.exceptions.CepNaoEncontradoException;
import com.example.testecd2.core.usecases.interfaces.ConsultaEnderecoPort;

public class ConsultaEndereco {

    private ConsultaEnderecoPort consultaEndereco;

    public ConsultaEndereco(ConsultaEnderecoPort consultaEndereco) {
        this.consultaEndereco = consultaEndereco;
    }

    public Endereco execute(String cep) {
        Endereco endereco = this.consultaEndereco.getEndereco(cep);
        try {
            if(endereco.getUf() == null) {
                throw new Exception();
            }
            return endereco;
        } catch (Exception ex) {
            throw new CepNaoEncontradoException("O cep " + cep + " é inválido!");
        }
    }
}
