package com.example.newsapi.dto;

import com.example.newsapi.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
