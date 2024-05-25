package com.example.testecd2.core.usecases.interfaces;

import com.example.testecd2.core.models.Endereco;

public interface ConsultaEnderecoPort {

    Endereco getEndereco(String cep);
}
