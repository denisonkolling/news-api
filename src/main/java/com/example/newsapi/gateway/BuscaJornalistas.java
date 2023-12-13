package com.example.newsapi.gateway;

import com.example.newsapi.model.Jornalista;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="busca-jornalista", url = "http://localhost:8080/jornalista")
public interface BuscaJornalistas {

    @GetMapping
    List<Jornalista> listarJornalistas();

}
