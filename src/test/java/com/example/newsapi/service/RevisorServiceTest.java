package com.example.newsapi.service;

import com.example.newsapi.model.Revisor;
import com.example.newsapi.model.UserRole;
import com.example.newsapi.model.Usuario;
import com.example.newsapi.repository.RevisorRepository;
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
class RevisorServiceTest {

    @Mock
    RevisorRepository repository;

    @InjectMocks
    RevisorService service;

    @Test
    void criarRevisor() {

        Revisor revisor = new Revisor(1,"nome", 3800.00, "cargo", new Usuario(1,"nome", "senha", UserRole.ADMIN));

        when(repository.save(any())).thenReturn(revisor);

        Revisor resultado = service.criarRevisor(revisor);

        assertNotNull(resultado);

        assertEquals(revisor.getNome(), resultado.getNome());
    }

    @Test
    void listarRevisor() {

        List<Revisor> revisores = List.of(new Revisor(1,"nome", 3800.00, "cargo", new Usuario(1,"nome", "senha", UserRole.ADMIN)));

        when(repository.findAll()).thenReturn(revisores);

        List<Revisor> resultado = service.listarRevisor();

        assertNotNull(resultado);

        assertEquals(revisores.get(0).getNome(), resultado.get(0).getNome());
    }

    @Test
    void atualizarRevisor() {
    }
}