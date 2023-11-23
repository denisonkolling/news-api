package com.example.newsapi.service;

import com.example.newsapi.model.Noticia;
import com.example.newsapi.repository.NoticiaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    NoticiaRepository noticiaRepository;

    private final Logger logger = LoggerFactory.getLogger(NoticiaService.class);

    public Noticia criarNoticia(Noticia noticia) {
        logger.info("Notícia criada: " + noticia.getTitulo() + " Data: " + LocalDateTime.now());
        return noticiaRepository.save(noticia);
    }

    public List<Noticia> listarNoticias() {
        logger.info("Listagem de notícias em " + LocalDateTime.now());
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

        logger.info("Notícia atualizada " + "Id: " + id + " Nome: " + noticia.getTitulo() + " Data: " + LocalDateTime.now());

        return noticiaRepository.save(noticiaBD);
    }

    public String excluirNoticia(Integer id) {
        var noticia = noticiaRepository.findById(id).get();

        logger.warn("Notícia Excluída: " + "Id: " + noticia.getId() + " Data: " + LocalDateTime.now());

        if (noticia != null) {
            noticiaRepository.delete(noticia);
            return "Notícia excluída com sucesso!";
        }

        return "Notícia não encontrada";
    }

}
