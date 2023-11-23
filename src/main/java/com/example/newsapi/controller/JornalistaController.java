package com.example.newsapi.controller;

import com.example.newsapi.model.Jornalista;
import com.example.newsapi.service.JornalistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jornalista")
public class JornalistaController {

    @Autowired
    JornalistaService jornalistaService;

    @GetMapping
    public ResponseEntity<?> listarJornalistas() {
        return new ResponseEntity<>(jornalistaService.listarJornalistas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarJornalista(@RequestBody Jornalista jornalista) {
        return new ResponseEntity<>(jornalistaService.criarJornalista(jornalista), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editarJornalista(@RequestBody Jornalista jornalista, @PathVariable Integer id) {
        return new ResponseEntity<>(jornalistaService.atualizarJornalista( jornalista, id), HttpStatus.CREATED);
    }


}
