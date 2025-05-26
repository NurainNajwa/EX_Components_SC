// src/main/java/com/example/login/LoginComponent.java
package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service                          // <– marks this as the LoginService bean
public class LoginComponent implements LoginService {
    private final UserRepository repo;
    private final Logger logger;

    @Autowired
    public LoginComponent(UserRepository repo, Logger logger) {
        this.repo   = repo;
        this.logger = logger;
    }

    @Override
    public boolean login(String username, String password) {
        logger.log("Attempting login for: " + username);
        if (!repo.exists(username)) {
            logger.log("User not found: " + username);
            return false;
        }
        boolean ok = repo.fetchPassword(username).equals(password);
        logger.log("Login " + (ok ? "successful" : "failed") + " for: " + username);
        return ok;
    }
}
