package com.demo.dztourism.Acommodation.User;

import com.demo.dztourism.Acommodation.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email) ;
    List<User> findByRoles(Role role) ;
}
