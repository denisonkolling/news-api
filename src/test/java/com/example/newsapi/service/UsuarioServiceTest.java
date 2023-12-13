package com.example.newsapi.service;

import com.example.newsapi.model.UserRole;
import com.example.newsapi.model.Usuario;
import com.example.newsapi.repository.UsuarioRepository;
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
class UsuarioServiceTest {

    @Mock
    UsuarioRepository repository;

    @InjectMocks
    UsuarioService service;

    @Test
    void criarUsuario() {

        Usuario usuario = new Usuario(1,"nome", "senha", UserRole.ADMIN);

        when(repository.save(any())).thenReturn(usuario);

        Usuario resultado = service.criarUsuario(usuario);

        assertNotNull(resultado);

        assertEquals(usuario.getNome(), resultado.getNome());

    }

    @Test
    void listarUsuarios() {

        List<Usuario> usuarios = List.of(new Usuario(1,"nome", "senha", UserRole.ADMIN));

        when(repository.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = service.listarUsuarios();

        assertNotNull(resultado);

        assertEquals(usuarios.get(0).getNome(), resultado.get(0).getNome());

    }
}