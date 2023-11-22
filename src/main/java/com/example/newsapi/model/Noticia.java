package com.example.newsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "NOTICIAS")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String textoNoticia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_revisor")
    private Revisor revisor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jornalista")
    private Jornalista jornalista;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;


}
