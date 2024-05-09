package com.demo.dztourism.Acommodation.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {

    @Id
    @GeneratedValue
    private Long id ;

    private String token ;

    private LocalDateTime createdAt ;
    private LocalDateTime expiresAt ;
    private LocalDateTime validatedAt ;

    @ManyToOne
    @JoinColumn(name = "userId" , nullable = false)
    private User user ;



}
