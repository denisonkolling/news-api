package com.example.newsapi.repository;

import com.example.newsapi.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository <Noticia, Integer> {
}
