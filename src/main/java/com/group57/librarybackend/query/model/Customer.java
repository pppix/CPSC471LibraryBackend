package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int custID;
    
    private String phoneNum;

    private String name;

    public Customer(){

    }

    public Customer(int custID, String phoneNum, String name){

        this.custID = custID;
        this.phoneNum = phoneNum;
        this.name = name;

    }
    
}
