package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "dependant")
public class Dependant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int EID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstName;

    public Dependant(){

    }

    public Dependant(int EID, String firstName){
        this.EID = EID;
        this.firstName = firstName;
    }
}
