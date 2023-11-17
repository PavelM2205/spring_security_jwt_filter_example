package com.example.jwt.api;

import com.example.jwt.api.model.Role;
import com.example.jwt.api.model.User;
import com.example.jwt.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityJwtFilterExampleApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUsers() {
        List<User> users = List.of(
                new User(1, "Pavel", passwordEncoder.encode("password1"), "pavel@mail", Role.ADMIN),
                new User(2, "Ivan", passwordEncoder.encode("password2"), "ivan@mail", Role.USER),
                new User(3, "Petr", passwordEncoder.encode("password3"), "petr@mail", Role.USER)

        );
        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtFilterExampleApplication.class, args);
        System.out.println("Go to http://localhost:9192/welcome");
    }
}
