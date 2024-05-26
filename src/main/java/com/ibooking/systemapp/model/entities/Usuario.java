package com.ibooking.systemapp.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "BOOKING_USER")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String roles;
}