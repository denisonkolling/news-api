package com.example.newsapi.service;

import com.example.newsapi.model.Revisor;
import com.example.newsapi.repository.RevisorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RevisorService {

    @Autowired
    RevisorRepository revisorRepository;

    private final Logger logger = LoggerFactory.getLogger(RevisorService.class);

    public Revisor criarRevisor(Revisor revisor) {
        logger.info("Revisor criado: " + revisor.getNome() + " Data: " + LocalDateTime.now());
        return revisorRepository.save(revisor);
    }

    public List<Revisor> listarRevisor() {
        logger.info("Listagem de revisores em " + LocalDateTime.now());
        return revisorRepository.findAll();
    }

    public Revisor atualizarRevisor(Revisor revisor, Integer id) {
        var revisorBD = revisorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Revisor não encontrado"));

        revisorBD.setNome(revisor.getNome());
        revisorBD.setNivelCargo(revisor.getNivelCargo());
        revisorBD.setSalario(revisor.getSalario());

        logger.info("Revisor atualizado " + "Id: " + id + " Nome: " + revisor.getNome() + " Data: " + LocalDateTime.now());

        return revisorRepository.save(revisorBD);
    }

}
