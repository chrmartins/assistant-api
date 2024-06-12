package br.com.chr3web.assistant.modules.user.adapter.controller;

import br.com.chr3web.assistant.modules.user.adapter.entities.UserEntity;
import br.com.chr3web.assistant.modules.user.adapter.mapper.UserMapper;
import br.com.chr3web.assistant.modules.user.application.service.UserServiceImpl;
import br.com.chr3web.assistant.modules.user.domain.model.User;
import br.com.chr3web.assistant.modules.user.exceptions.UserAlreadyExistsException;
import br.com.chr3web.assistant.modules.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Usuário já registrado.");
        }
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com email: " + email));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        User user = UserMapper.toDomain(userEntity);
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
}