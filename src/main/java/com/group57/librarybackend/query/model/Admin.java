package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "admin")
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public Admin(){

    }

    public Admin(int ID){
        this.ID = ID;
    }


}
