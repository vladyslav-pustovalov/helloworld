package com.javaproject.helloworld.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.helloworld.model.Pet;
import com.javaproject.helloworld.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

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

//    @PostMapping("/pet")
//    public String createPetByJSON() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Pet pet = objectMapper.readValue(new File("/pet"), Pet.class);
//        return "redirect:/pet";
//    }
    @PostMapping
    public Pet createPetByBody(@RequestBody Pet pet) {
        return service.createPet(pet);
    }
}
