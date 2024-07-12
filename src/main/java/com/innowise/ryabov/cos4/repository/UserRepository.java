package com.innowise.ryabov.cos4.repository;

import com.innowise.ryabov.cos4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
