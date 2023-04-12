package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@IdClass(DependantID.class)
@Table(name = "dependant")
public class Dependant {
    
    @Id
    public int EID;

    @Id
    public String firstName;

    public Dependant(){

    }

    public Dependant(int EID, String firstName){
        this.EID = EID;
        this.firstName = firstName;
    }
}
