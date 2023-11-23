package com.example.newsapi.controller;

import com.example.newsapi.model.Jornalista;
import com.example.newsapi.model.Noticia;
import com.example.newsapi.service.JornalistaService;
import com.example.newsapi.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<?> listarNoticias() {
        return new ResponseEntity<>(noticiaService.listarNoticias(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarNoticia(@RequestBody Noticia noticia) {
        return new ResponseEntity<>(noticiaService.criarNoticia(noticia), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirNoticia(@PathVariable Integer id) {
        return new ResponseEntity<>(noticiaService.excluirNoticia(id), HttpStatus.OK);
    }
}
