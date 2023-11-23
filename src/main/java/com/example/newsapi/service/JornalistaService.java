package com.example.newsapi.service;

import com.example.newsapi.model.Jornalista;
import com.example.newsapi.repository.JornalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornalistaService {

    @Autowired
    JornalistaRepository jornalistaRepository;

    public Jornalista criarJornalista(Jornalista jornalista) {
        return jornalistaRepository.save(jornalista);
    }

    public List<Jornalista> listarJornalistas() {
        return jornalistaRepository.findAll();
    }

    public Jornalista atualizarJornalista(Jornalista jornalista, Integer id) {
        var jornalistaBD = jornalistaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Jornalista não encontrado"));

        jornalistaBD.setNome(jornalista.getNome());
        jornalistaBD.setNivelCargo(jornalista.getNivelCargo());
        jornalistaBD.setSalario(jornalista.getSalario());
        jornalistaBD.setNumeroPublicacoes(jornalista.getNumeroPublicacoes());

        return jornalistaRepository.save(jornalistaBD);
    }


}
