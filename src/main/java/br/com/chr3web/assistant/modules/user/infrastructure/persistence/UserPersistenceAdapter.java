package br.com.chr3web.assistant.modules.user.infrastructure.persistence;

import br.com.chr3web.assistant.modules.user.domain.entities.User;
import br.com.chr3web.assistant.modules.user.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter {
    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        AppUser appUser = UserMapper.toAppUser(user);
        userRepository.save(appUser);
    }
}