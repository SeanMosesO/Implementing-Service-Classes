package com.seanmotech.Implementing.Service.Classes;

import org.springframework.stereotype.Service;

@Service // Registers this class as a Spring Bean
public class MessageService {

    public String getMessage() {
        return "Dependency Injected Message!";
    }

    public String getSpecificMessage(String type) {
        return "Injected via " + type + " successfully.";
    }
}