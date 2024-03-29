package com.app.curs15.controller;

import com.app.curs15.exception.AuthenticationException;
import com.app.curs15.models.Message;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class Home {

    @PostMapping(value = "/messages")
    public ResponseEntity<String> postMessage(@Valid @RequestBody Message message, @RequestHeader(required = false) String authentication) {
        if (authentication == null) {
            throw new AuthenticationException("Authentication header missing.");
        }
        if (!authentication.equals("devmind-api-key")) {
            throw new AuthenticationException("Authentication failed.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Message created.");
    }
}
