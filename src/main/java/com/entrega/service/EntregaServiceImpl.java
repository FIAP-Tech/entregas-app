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

    public Optional<Entrega> getEntregaById(Long id) {
        return entregaRepository.findById(String.valueOf(id));
    }

    public void criarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    public void atualizarEntrega(Long id, Entrega entrega) {
        entregaRepository.findById(String.valueOf(id));
        entregaRepository.save(entrega);

    }

    public void excluirEntrega(Long id) {
        entregaRepository.findById(String.valueOf(id));
        entregaRepository.deleteById(String.valueOf(id));
    }
}
