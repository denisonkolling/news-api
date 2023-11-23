package com.example.newsapi.service;

import com.example.newsapi.model.Usuario;
import com.example.newsapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }


}
