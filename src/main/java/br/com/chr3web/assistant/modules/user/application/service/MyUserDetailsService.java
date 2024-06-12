package br.com.chr3web.assistant.modules.user.application.service;

import br.com.chr3web.assistant.modules.user.infrastructure.persistence.UserRepository;
import br.com.chr3web.assistant.modules.user.infrastructure.persistence.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(email);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(appUser.getEmail(), appUser.getPassword(), Collections.emptyList());
    }
}