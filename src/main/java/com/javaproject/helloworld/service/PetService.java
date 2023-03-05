package com.javaproject.helloworld.service;

import com.javaproject.helloworld.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Service
public class PetService {

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private final WebClient localApiClient;

    @Autowired
    public PetService() {
        this.localApiClient = WebClient.create(BASE_URL);
    }

    public Pet getPet(String id) {
        return localApiClient
                .get()
                .uri("/pet/"+id)
                .retrieve()
                .bodyToMono(Pet.class)
                .block(REQUEST_TIMEOUT);
    }

    public Pet createPet(Pet createdPet) {
        return localApiClient
                .post()
                .uri("/pet")
                .bodyValue(createdPet)
                .retrieve()
                .bodyToMono(Pet.class)
                .block(REQUEST_TIMEOUT);
    }

    public Pet updatePet(Pet updatedPet) {
        return localApiClient
                .put()
                .uri("/pet")
                .bodyValue(updatedPet)
                .retrieve()
                .bodyToMono(Pet.class)
                .block(REQUEST_TIMEOUT);
    }

    public Pet deletePet(String id) {
        return localApiClient
                .delete()
                .uri("/pet/"+id)
                .retrieve()
                .bodyToMono(Pet.class)
                .block(REQUEST_TIMEOUT);
    }
}
