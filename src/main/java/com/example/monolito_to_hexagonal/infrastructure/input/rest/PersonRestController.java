package com.example.monolito_to_hexagonal.infrastructure.input.rest;

import com.example.monolito_to_hexagonal.application.dto.PersonRequest;
import com.example.monolito_to_hexagonal.application.dto.PersonResponse;
import com.example.monolito_to_hexagonal.application.handler.IPersonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonRestController {

    private final IPersonHandler personHandler;

    @PostMapping("/")
    public ResponseEntity<Void>  savePersonInBD(@RequestBody PersonRequest personRequest){
        personHandler.savePersonInBD(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonResponse>> getAllPersonFromBD(){
        return ResponseEntity.ok(personHandler.getAllPersonFromBD());
    }

    @GetMapping("/{number}")
    public ResponseEntity<PersonResponse> getPersonFromBD(@PathVariable(name = "number") Long personNumber){
        return ResponseEntity.ok(personHandler.getPersonFromBD(personNumber));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updatePersonInBD(@RequestBody PersonRequest personRequest){
        personHandler.updatePersonInBD(personRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/personNumber")
    public ResponseEntity<Void> deletePersonFromDB(@PathVariable Long personNumber){
        personHandler.deletePersonFromDB(personNumber);
        return ResponseEntity.noContent().build();
    }

}
