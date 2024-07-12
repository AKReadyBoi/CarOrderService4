package com.innowise.ryabov.cos4.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname",nullable = false)
    private String firstname;
    @Column(name = "lastname",nullable = false)
    private String lastname;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number",nullable = false, unique = true)
    private String phone_number;
    @Column(name = "creation_date",nullable = false)
    private Date creation_date;
    @Column(name = "passport_id",nullable = false, unique = true)
    private String passport_id;
    @Column(name = "driving_license_id",nullable = false, unique = true)
    private String driving_license_id;
}
