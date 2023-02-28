package com.javaproject.helloworld.controller;

import com.javaproject.helloworld.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping("/pet")
    public String getPetById(String id) {
        return service.getPet(id).toString();
    }
}
