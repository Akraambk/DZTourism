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


     @PostMapping("/registerUser")
     @ResponseStatus(HttpStatus.ACCEPTED)
     public ResponseEntity<?> registerUser (@RequestBody @Valid RegistrationRequest registrationRequest) throws MessagingException {

         authenticationService.registerUser(registrationRequest) ;
         return ResponseEntity.accepted().build() ;

     }

    @PostMapping("/registerProvider")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> registerProvider (@RequestBody @Valid RegistrationRequest registrationRequest) throws MessagingException {

        authenticationService.registerProvider(registrationRequest) ;
        return ResponseEntity.accepted().build() ;

    }


     @PostMapping("/authenticate")
     public ResponseEntity<AuthenticationResponse> authenticate(
             @RequestBody @Valid AuthenticationRequest request){

         return ResponseEntity.ok(authenticationService.authenticate(request)) ;


     }

     @GetMapping("activate-account")
    public void confirm(@RequestParam String token) throws MessagingException {

         authenticationService.activateAccount(token) ;

     }




}
