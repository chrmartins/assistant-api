package br.com.chr3web.assistant.modules.user.application.service;

import br.com.chr3web.assistant.modules.user.domain.model.User;
import br.com.chr3web.assistant.modules.user.domain.repository.UserRepository;
import br.com.chr3web.assistant.modules.user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setPassword(user.getPassword());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }
}