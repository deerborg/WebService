package com.example.webservice.v1.repository;

import com.example.webservice.v1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
    User findByUsername(String username);
    @Query("select u.email from User u where u.id = :id")
    String getUserByEmail(@Param("id") Long id);
}
