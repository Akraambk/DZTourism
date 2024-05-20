package com.demo.dztourism.Acommodation.Authentication;

import com.demo.dztourism.Acommodation.Email.EmailService;
import com.demo.dztourism.Acommodation.Email.EmailTemplateName;
import com.demo.dztourism.Acommodation.Role.RoleRepository;
import com.demo.dztourism.Acommodation.Security.JwtService;
import com.demo.dztourism.Acommodation.User.Token;
import com.demo.dztourism.Acommodation.User.TokenRepository;
import com.demo.dztourism.Acommodation.User.User;
import com.demo.dztourism.Acommodation.User.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository ;
    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;
    private final TokenRepository tokenRepository ;
    private final EmailService emailService ;
    private final AuthenticationManager authenticationManager ;
    private final JwtService jwtService ;
    @Value("${application.security.mailing.frontend.activation-url}")
    private String confirmationUrl;
    public void register(RegistrationRequest registrationRequest) throws MessagingException {

        var userRoles = roleRepository.findByName("USER")
                .orElseThrow( () -> new IllegalStateException(" Role not initialized " )) ;
        var user = User.builder()
                .FirstName(registrationRequest.getFirstName())
                .LastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .Locked(false)
                .enabled(false)
                .roles(List.of(userRoles))
                .build() ;

        userRepository.save(user) ;
        sendValidationEmail(user);


    }

    private void sendValidationEmail(User user) throws MessagingException {
        var token = generateAndSaveValidationCode(user) ;

        emailService.sendMail(user.getEmail() ,
                user.getFullName() ,
                EmailTemplateName.ACTIVATE,
                confirmationUrl ,
                token ,
                "Account activation");


    }

    private String generateAndSaveValidationCode(User user) {

        String generatedToken = generateActivationCode(6) ;
        var token =  Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build() ;
        tokenRepository.save(token) ;
        return generatedToken ;
    }


    public String generateActivationCode(int length) {
        String characters = "0123456789" ;
        StringBuilder stringBuilder = new StringBuilder() ;
        SecureRandom secureRandom = new SecureRandom() ;

        for (int i = 0 ; i < length ; i++) {
            int randomIndex = secureRandom.nextInt(characters.length()) ;
            stringBuilder.append(characters.charAt(randomIndex)) ;
        }
        return stringBuilder.toString() ;
  }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        var auth =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail() ,
                        request.getPassword()
                )
        ) ;

        var claims = new HashMap<String , Object>() ;
        var user = ((User)auth.getPrincipal()) ;
        claims.put("FullName" , user.getFullName()) ;

        var jwtToken = jwtService.generateToken(claims , user ) ;

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Transactional
    public void activateAccount(String token) throws MessagingException {

        Token savedtoken = tokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Invalid token")) ;
        if (LocalDateTime.now().isAfter(savedtoken.getExpiresAt())){

            sendValidationEmail(savedtoken.getUser());
            throw new RuntimeException("Activation token has expired , a new token has being send to the same email ") ;
        }
        var user = userRepository.findById(savedtoken.getUser().getID())
                .orElseThrow(()-> new UsernameNotFoundException("User not found ")) ;
        user.setEnabled(true);
        userRepository.save(user) ;
        savedtoken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedtoken);


    }
}
