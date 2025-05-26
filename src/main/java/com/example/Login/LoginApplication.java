// src/main/java/com/example/login/LoginApplication.java
package com.example.login;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication    // @Configuration + @ComponentScan + @EnableAutoConfig
public class LoginApplication implements CommandLineRunner {
    private final LoginService loginService;

    public LoginApplication(LoginService loginService) {
        this.loginService = loginService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // quick smoke test
        loginService.login("alice", "pass123");
        loginService.login("alice", "badpass");
        System.exit(0);
    }
}
