// src/main/java/com/example/login/UserRepository.java
package com.example.login;

public interface UserRepository {
    boolean exists(String username);
    String fetchPassword(String username);
}
