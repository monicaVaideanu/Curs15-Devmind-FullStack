package com.app.curs15.controller;

import com.app.curs15.models.Message;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class Home {
    @ExceptionHandler
    @PostMapping(value="/messages")
    public ResponseEntity<HttpStatus> getMessage(@Valid @RequestBody Message message, @RequestHeader(value = "authentication") String authentication) {
        try{if(authentication.equals("devmind-api-key"))
            return new ResponseEntity<>(HttpStatus.CREATED);}
        catch (IllegalStateException e){
            throw new IllegalStateException("Sth wrong");
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
