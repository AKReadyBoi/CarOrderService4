package com.innowise.ryabov.cos4.repository;

import com.innowise.ryabov.cos4.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByDrivingLicenseId(String drivingLicense);
    boolean existsByEmail(String email);
    boolean existsByPassportId(String passportId);
    boolean existsByPhoneNumber(String phoneNumber);
}
