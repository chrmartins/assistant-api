package br.com.chr3web.assistant.modules.user.domain.mapper;

import br.com.chr3web.assistant.modules.user.domain.entities.User;
import br.com.chr3web.assistant.modules.user.infrastructure.persistence.AppUser;

public class UserMapper {
    public static AppUser toAppUser(User user) {
        AppUser appUser = new AppUser();
        appUser.setName(user.getName());
        appUser.setEmail(user.getEmail());
        appUser.setPassword(user.getPassword());
        return appUser;
    }

    public static User toUser(AppUser appUser) {
        User user = new User();
        user.setName(appUser.getName());
        user.setEmail(appUser.getEmail());
        user.setPassword(appUser.getPassword());
        return user;
    }
}
