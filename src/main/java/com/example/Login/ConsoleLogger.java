// src/main/java/com/example/login/ConsoleLogger.java
package com.example.login;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component                         // <– bean named “consoleLogger”
public class ConsoleLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println(LocalDateTime.now() + "    " + msg);
    }
}
