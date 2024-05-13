package com.demo.dztourism.Acommodation.Authentication;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService ;


     @PostMapping("/register")
     @ResponseStatus(HttpStatus.ACCEPTED)
     public ResponseEntity<?> register (@RequestBody @Valid RegistrationRequest registrationRequest) throws MessagingException {

         authenticationService.register(registrationRequest) ;
         return ResponseEntity.accepted().build() ;

     }



}
