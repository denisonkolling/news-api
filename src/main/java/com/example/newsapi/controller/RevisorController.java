package com.example.newsapi.controller;

import com.example.newsapi.model.Revisor;
import com.example.newsapi.service.RevisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revisor")
public class RevisorController {

    @Autowired
    RevisorService revisorService;

    @GetMapping
    public ResponseEntity<?> listarRevisores() {
        return new ResponseEntity<>(revisorService.listarRevisor(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarRevisor(@RequestBody Revisor revisor) {
        return new ResponseEntity<>(revisorService.criarRevisor(revisor), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editarRevisor(@RequestBody Revisor revisor, @PathVariable Integer id) {
        return new ResponseEntity<>(revisorService.atualizarRevisor( revisor, id), HttpStatus.CREATED);
    }

}
