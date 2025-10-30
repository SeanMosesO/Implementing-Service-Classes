package com.seanmotech.Implementing.Service.Classes;

import com.example.dipractice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InjectionDemoRunner implements CommandLineRunner {

    // --- C. Field Injection (Least Recommended) ---
    @Autowired
    private MessageService fieldMessageService;

    // --- B. Setter Injection (Flexible) ---
    private MessageService setterMessageService;

    @Autowired
    public void setSetterMessageService(MessageService setterMessageService) {
        this.setterMessageService = setterMessageService;
    }

    // --- A. Constructor Injection (Best Practice) ---
    private final MessageService constructorMessageService;

    // Spring injects here. @Autowired is optional since this is the only constructor.
    public InjectionDemoRunner(MessageService constructorMessageService) {
        this.constructorMessageService = constructorMessageService;
    }


    @Override
    public void run(String... args) throws Exception {

        // Execute Constructor Injection logic
        System.out.println("\n--- 1. Constructor Injection (Recommended) ---");
        System.out.println(
            constructorMessageService.getSpecificMessage("Constructor")
        );

        // Execute Setter Injection logic
        System.out.println("\n--- 2. Setter Injection ---");
        System.out.println(
            setterMessageService.getSpecificMessage("Setter")
        );

        // Execute Field Injection logic
        System.out.println("\n--- 3. Field Injection (Avoid in Production) ---");
        System.out.println(
            fieldMessageService.getSpecificMessage("Field")
        );
        System.out.println("----------------------------------------------\n");
    }
}