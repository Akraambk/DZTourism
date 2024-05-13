package com.demo.dztourism.Acommodation.Authentication;

import com.demo.dztourism.Acommodation.Email.EmailService;
import com.demo.dztourism.Acommodation.Email.EmailTemplateName;
import com.demo.dztourism.Acommodation.Role.RoleRepository;
import com.demo.dztourism.Acommodation.User.Token;
import com.demo.dztourism.Acommodation.User.TokenRepository;
import com.demo.dztourism.Acommodation.User.User;
import com.demo.dztourism.Acommodation.User.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository ;
    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;
    private final TokenRepository tokenRepository ;
    private final EmailService emailService ;
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
                EmailTemplateName.ACTIVATE_ACCOUNT,
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
}
