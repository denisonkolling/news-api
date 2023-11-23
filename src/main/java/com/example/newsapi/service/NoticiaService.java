package com.example.newsapi.service;

import com.example.newsapi.model.Noticia;
import com.example.newsapi.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    NoticiaRepository noticiaRepository;

    public Noticia criarNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAll();
    }

    public Noticia recuperarNoticia(Integer id) {
        return noticiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Notícia não encontrada"));
    }

    public Noticia atualizarNoticia(Noticia noticia, Integer id) {
        var noticiaBD = noticiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Notícia não encontrada"));

        noticiaBD.setJornalista(noticia.getJornalista());
        noticiaBD.setRevisor(noticia.getRevisor());
        noticiaBD.setTitulo(noticia.getTitulo());
        noticiaBD.setTextoNoticia(noticia.getTextoNoticia());

        return noticiaRepository.save(noticiaBD);
    }

    public String excluirNoticia(Integer id) {
        var noticia = noticiaRepository.findById(id).get();

        if (noticia != null) {
            noticiaRepository.delete(noticia);
            return "Notícia excluída com sucesso!";
        }

        return "Notícia não encontrada";
    }

}
