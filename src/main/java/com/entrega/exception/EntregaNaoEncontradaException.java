package com.entrega.exception;

public class EntregaNaoEncontradaException extends RuntimeException {
    public EntregaNaoEncontradaException(String id) {
        super("Entrega não encontrada com o ID: " + id);
    }
}
