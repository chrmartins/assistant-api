package br.com.chr3web.assistant.security.service;

import br.com.chr3web.assistant.modules.user.adapter.repository.JpaUserRepository;
import br.com.chr3web.assistant.modules.user.adapter.mapper.UserMapper;
import br.com.chr3web.assistant.modules.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Primary
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JpaUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .map(UserMapper::toDomain)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}