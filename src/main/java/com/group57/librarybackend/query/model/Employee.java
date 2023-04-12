package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int ID;
    public String firstName;
    public String lastName;

    public Employee(){

    }
    
    public Employee(int ID, String firstName, String lastName){

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
