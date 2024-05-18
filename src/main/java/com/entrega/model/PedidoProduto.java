package com.entrega.model;

import lombok.Data;

@Data
public class PedidoProduto {
    long idproduto;
    String Descricao;
    int quantidade;
    double preco;
}
