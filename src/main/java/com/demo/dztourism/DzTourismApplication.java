package com.demo.dztourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DzTourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(DzTourismApplication.class, args);
    }

}
