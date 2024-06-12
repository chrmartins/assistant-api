package br.com.chr3web.assistant.modules.user.domain.usecases;

import br.com.chr3web.assistant.modules.user.domain.entities.User;
import br.com.chr3web.assistant.modules.user.infrastructure.persistence.UserPersistenceAdapter;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCase {
    private final UserPersistenceAdapter userPersistenceAdapter;

    public RegisterUserUseCase(UserPersistenceAdapter userPersistenceAdapter) {
        this.userPersistenceAdapter = userPersistenceAdapter;
    }

    public void execute(User user) {
        userPersistenceAdapter.save(user);
    }
}