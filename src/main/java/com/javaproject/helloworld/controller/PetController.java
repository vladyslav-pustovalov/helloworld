package com.javaproject.helloworld.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.helloworld.model.Pet;
import com.javaproject.helloworld.service.PetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RestController
public class PetController {
    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping("/pet")
    public Pet getPetById(String id) {
        return service.getPet(id);
    }

    @PostMapping("/pet")
    public Pet createPetByBody(@RequestBody Pet pet) {
        return service.createPet(pet);
    }

    @PutMapping("/pet")
    public Pet updatePetByBody (@RequestBody Pet pet) {
        return service.updatePet(pet);
    }

    @DeleteMapping("/pet")
    public Pet deletePetById (String id) {
        return service.deletePet(id);
    }
}
