package br.com.chr3web.assistant.modules.user.adapter.mapper;

import br.com.chr3web.assistant.modules.user.domain.model.User;
import br.com.chr3web.assistant.modules.user.adapter.entities.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getName(),
                userEntity.getPassword()
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}