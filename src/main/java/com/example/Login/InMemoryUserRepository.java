// src/main/java/com/example/login/InMemoryUserRepository.java
package com.example.login;

import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository                        // <– bean named “inMemoryUserRepository”
public class InMemoryUserRepository implements UserRepository {
    private final Map<String,String> users = new ConcurrentHashMap<>();
    
    public InMemoryUserRepository() {
        users.put("alice","pass123");
        users.put("bob","qwerty");
    }
    @Override
    public boolean exists(String u) { return users.containsKey(u); }
    @Override
    public String fetchPassword(String u) { return users.get(u); }
}
