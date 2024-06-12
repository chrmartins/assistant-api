package br.com.chr3web.assistant.modules.user.domain.service;

import br.com.chr3web.assistant.modules.user.domain.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    User saveUser(User user);
    User updateUser(User user);
}