package com.intercorp.ms01.model;

import java.util.List;
import jakarta.persistence.ElementCollection;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String firstname2;
    private String lastname2;
    private String city;
    private String country;
    private String email;
    private int random;
    private double randomFloat;
    private boolean bool;
    private String date;
    private String regex;
    private String enumValue;
    @ElementCollection
    private List  <String> elements;
        private int age;
}
