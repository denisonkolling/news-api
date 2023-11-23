package com.example.newsapi.service;

import com.example.newsapi.model.Jornalista;
import com.example.newsapi.repository.JornalistaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JornalistaService {

    @Autowired
    JornalistaRepository jornalistaRepository;

    private final Logger logger = LoggerFactory.getLogger(JornalistaService.class);

    public Jornalista criarJornalista(Jornalista jornalista) {
        logger.info("Jornalista criado: " + jornalista.getNome() + " Data: " + LocalDateTime.now());
        return jornalistaRepository.save(jornalista);
    }

    public List<Jornalista> listarJornalistas() {
        logger.info("Listagem de jornalistas em " + LocalDateTime.now());
        return jornalistaRepository.findAll();
    }

    public Jornalista atualizarJornalista(Jornalista jornalista, Integer id) {
        var jornalistaBD = jornalistaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Jornalista não encontrado"));

        jornalistaBD.setNome(jornalista.getNome());
        jornalistaBD.setNivelCargo(jornalista.getNivelCargo());
        jornalistaBD.setSalario(jornalista.getSalario());
        jornalistaBD.setNumeroPublicacoes(jornalista.getNumeroPublicacoes());

        logger.warn("Jornalista atualizado " + "Id: " + id + " Nome: " + jornalista.getNome() + " Data: " + LocalDateTime.now());

        return jornalistaRepository.save(jornalistaBD);
    }


}
