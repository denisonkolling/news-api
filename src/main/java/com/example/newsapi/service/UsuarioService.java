package com.example.newsapi.service;

import com.example.newsapi.model.Usuario;
import com.example.newsapi.repository.UsuarioRepository;

import org.hibernate.grammars.hql.HqlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public Usuario criarUsuario(Usuario usuario) {
        logger.info("Usuário criado: " + usuario.getNomeUsuario() + " Data: " + LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        logger.info("Listagem de usuários em " + LocalDateTime.now());
        return usuarioRepository.findAll();
    }


}
