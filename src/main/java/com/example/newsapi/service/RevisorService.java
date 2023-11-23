package com.example.newsapi.service;

import com.example.newsapi.model.Revisor;
import com.example.newsapi.repository.RevisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisorService {

    @Autowired
    RevisorRepository revisorRepository;

    public Revisor criarRevisor(Revisor revisor) {
        return revisorRepository.save(revisor);
    }

    public List<Revisor> listarRevisor() {
        return revisorRepository.findAll();
    }

    public Revisor atualizarRevisor(Revisor revisor, Integer id) {
        var revisorBD = revisorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Revisor não encontrado"));

        revisorBD.setNome(revisor.getNome());
        revisorBD.setNivelCargo(revisor.getNivelCargo());
        revisorBD.setSalario(revisor.getSalario());

        return revisorRepository.save(revisorBD);
    }

}
