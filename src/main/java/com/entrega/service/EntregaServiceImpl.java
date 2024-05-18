package com.entrega.service;

import com.entrega.model.Entrega;
import com.entrega.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntregaServiceImpl {

    private EntregaRepository entregaRepository;
    @Autowired
    public EntregaServiceImpl(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }
    public Iterable<Entrega> getEntregas() {
       return entregaRepository.findAll();
    }
    public Optional<Entrega> getEntregaById(String id) {
        return entregaRepository.findById(id);
    }
    public Entrega criarEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }
    public void atualizarEntrega(String id, Entrega entrega) {
        entregaRepository.findById(id);
        entregaRepository.save(entrega);
    }
    public void excluirEntrega(String id) {
        entregaRepository.findById(id);
        entregaRepository.deleteById(id);
    }
}
