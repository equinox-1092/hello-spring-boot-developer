package com.acme.hello.platform.generic.interfaces.rest.controllers;

import com.acme.hello.platform.generic.domain.model.entities.Developer;
import com.acme.hello.platform.generic.interfaces.rest.assemblers.DeveloperAssembler;
import com.acme.hello.platform.generic.interfaces.rest.assemblers.GreetDeveloperResponseAssembler;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import com.acme.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @GetMapping
    public ResponseEntity<GreetDeveloperResponse> greetDeveloper(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        Developer developer = (firstName != null && lastName != null)
                ? Developer.builder().firstName(firstName).lastName(lastName).build()
                : null;
        GreetDeveloperResponse response = GreetDeveloperResponseAssembler
                .toResponseFromEntity(developer);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GreetDeveloperResponse> createGreeting(
            @RequestBody GreetDeveloperRequest request) {
        Developer developer = DeveloperAssembler.toEntityFromRequest(request);
        GreetDeveloperResponse response = GreetDeveloperResponseAssembler
                .toResponseFromEntity(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
