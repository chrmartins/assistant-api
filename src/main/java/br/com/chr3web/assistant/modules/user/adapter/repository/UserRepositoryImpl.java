package br.com.chr3web.assistant.modules.user.adapter.repository;

import br.com.chr3web.assistant.modules.user.adapter.entities.UserEntity;
import br.com.chr3web.assistant.modules.user.adapter.mapper.UserMapper;
import br.com.chr3web.assistant.modules.user.domain.model.User;
import br.com.chr3web.assistant.modules.user.domain.repository.UserRepository;
import br.com.chr3web.assistant.modules.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        return UserMapper.toDomain(jpaUserRepository.save(userEntity));
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        if (jpaUserRepository.existsById(userEntity.getId())) {
            return UserMapper.toDomain(jpaUserRepository.save(userEntity));
        }
        throw new UserNotFoundException("Usuário não encontrado com o ID: " + user.getId());
    }
}