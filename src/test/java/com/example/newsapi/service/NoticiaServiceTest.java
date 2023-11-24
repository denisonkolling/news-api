package com.example.newsapi.service;

import com.example.newsapi.model.Jornalista;
import com.example.newsapi.model.Noticia;
import com.example.newsapi.model.Revisor;
import com.example.newsapi.model.Usuario;
import com.example.newsapi.repository.NoticiaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoticiaServiceTest {

    @Mock
    NoticiaRepository repository;

    @InjectMocks
    NoticiaService service;

    @Test
    void criarNoticia() {

        Noticia noticia =
                new Noticia(1, "Título da Notícia", "Conteúdo da notícia fictícia...",
                new Revisor(1,"nome", 3800.00, "cargo", new Usuario(1,"nome", "senha")),
                new Jornalista(1,"nome", 3800.00, "cargo", 25, new Usuario(2,"nome", "senha")),
                        LocalDateTime.now(), LocalDateTime.now());

        when(repository.save(any())).thenReturn(noticia);

        Noticia resultado = service.criarNoticia(noticia);

        assertNotNull(resultado);

        assertEquals(noticia.getTitulo(), resultado.getTitulo());

    }

    @Test
    void listarNoticias() {

        List<Noticia> noticias = List.of(new Noticia(1, "Título da Notícia", "Conteúdo da notícia fictícia...",
                new Revisor(1,"nome", 3800.00, "cargo", new Usuario(1,"nome", "senha")),
                new Jornalista(1,"nome", 3800.00, "cargo", 25, new Usuario(2,"nome", "senha")),
                LocalDateTime.now(), LocalDateTime.now()));

        when(repository.findAll()).thenReturn(noticias);

        List<Noticia> resultado = service.listarNoticias();

        assertNotNull(resultado);

        assertEquals(noticias.get(0).getTitulo(), resultado.get(0).getTitulo());

    }

    @Test
    void excluirNoticia() {
    }
}