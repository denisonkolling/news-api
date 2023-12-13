package com.example.newsapi.service;

import com.example.newsapi.model.Jornalista;
import com.example.newsapi.model.Revisor;
import com.example.newsapi.model.UserRole;
import com.example.newsapi.model.Usuario;
import com.example.newsapi.repository.JornalistaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JornalistaServiceTest {

    @Mock
    JornalistaRepository repository;

    @InjectMocks
    JornalistaService service;

    @Test
    void criarJornalista() {

        Jornalista jornalista = new Jornalista(1,"nome", 3800.00, "cargo", 25, new Usuario(1,"nome", "senha", UserRole.ADMIN));

        when(repository.save(any())).thenReturn(jornalista);

        Jornalista resultado = service.criarJornalista(jornalista);

        assertNotNull(resultado);

        assertEquals(jornalista.getNome(), resultado.getNome());
    }

    @Test
    void listarJornalistas() {

        List<Jornalista> jornalistas = List.of(new Jornalista(1,"nome", 3800.00, "cargo", 25, new Usuario(1,"nome", "senha", UserRole.ADMIN)));

        when(repository.findAll()).thenReturn(jornalistas);

        List<Jornalista> resultado = service.listarJornalistas();

        assertNotNull(resultado);

        assertEquals(jornalistas.get(0).getNome(), resultado.get(0).getNome());

    }

}