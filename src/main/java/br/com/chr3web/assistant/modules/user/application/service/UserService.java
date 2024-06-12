package br.com.chr3web.assistant.modules.user.application.service;

import br.com.chr3web.assistant.modules.user.application.dto.UserDTO;
import br.com.chr3web.assistant.modules.user.domain.entities.User;
import br.com.chr3web.assistant.modules.user.domain.mapper.UserMapper;
import br.com.chr3web.assistant.modules.user.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(UserMapper.toAppUser(user));
    }
}