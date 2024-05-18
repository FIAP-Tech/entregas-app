package com.entrega.model;

import lombok.Data;

@Data
public class Endereco {
    String logradouro;
    String bairro;
    String estado;
    String cidade;
    String cep;
}
