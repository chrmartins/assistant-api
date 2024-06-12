package br.com.chr3web.assistant;

import br.com.chr3web.assistant.modules.user.adapter.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssistantApplication {

	private final UserRepositoryImpl userRepositoryImpl;

	@Autowired
	public AssistantApplication(UserRepositoryImpl userRepositoryImpl) {
		this.userRepositoryImpl = userRepositoryImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}
}