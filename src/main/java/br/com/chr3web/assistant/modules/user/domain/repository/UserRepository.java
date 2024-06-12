package br.com.chr3web.assistant.modules.user.domain.repository;

import br.com.chr3web.assistant.modules.user.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    User updateSave(User user); // Adicionando o método updateSave
}