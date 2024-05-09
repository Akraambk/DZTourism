package com.demo.dztourism.Acommodation.User;

import com.demo.dztourism.Acommodation.Role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails , Principal {


    @Id
    private Long Id ;
    private String FirstName ;
    private String LastName ;
    private LocalDate birthDate ;
    @Column(unique = true)
    private String email ;
    private String password ;
    private boolean Locked ;
    private boolean enabled ;

    @CreatedDate
    @Column(nullable = false , updatable = false)
    private LocalDateTime CreatedDate ;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime LastModifiedDate ;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles ;



    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !Locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    private String getFullName(){
        return FirstName+" "+LastName;
    }
}
