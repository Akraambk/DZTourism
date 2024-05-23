package com.demo.dztourism;

import com.demo.dztourism.Acommodation.Role.Role;
import com.demo.dztourism.Acommodation.Role.RoleRepository;
import com.demo.dztourism.Acommodation.User.User;
import com.demo.dztourism.Acommodation.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@RequiredArgsConstructor
public class DzTourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(DzTourismApplication.class, args)



        ;
    }
    private final PasswordEncoder passwordEncoder ;
    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository , UserRepository userRepository) {
        return args -> {
            if (roleRepository.findByName("ROLE_USER").isEmpty()) {
                roleRepository.save(Role.builder().name("ROLE_USER").build());
            }
            if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
                roleRepository.save(Role.builder().name("ROLE_ADMIN").build());
            }
            if (roleRepository.findByName("ROLE_PROVIDER").isEmpty()) {
                roleRepository.save(Role.builder().name("ROLE_PROVIDER").build());
            }

           Optional<Role> adminRole =  roleRepository.findByName("ROLE_ADMIN") ;
           Role retrievedRole = adminRole.orElseThrow(() -> new RuntimeException(" role not found ")) ;

          if ( userRepository.findByRoles(retrievedRole).isEmpty() ){
              var admin = User.builder()
                      .FirstName("Admin")
                      .LastName("Admin")
                      .email("admin@gmail.com")
                      .password(passwordEncoder.encode("rootAdmin"))
                      .Locked(false)
                      .enabled(true)
                      .roles(List.of(retrievedRole))
                      .build() ;

              userRepository.save(admin) ;
          }




        };
    }

}
