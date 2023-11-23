package com.example.newsapi.repository;

import com.example.newsapi.model.Jornalista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JornalistaRepository extends JpaRepository <Jornalista, Integer> {
}
