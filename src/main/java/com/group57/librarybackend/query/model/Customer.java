package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "customer")
@SequenceGenerator(name="customer_id_seq", initialValue=103, allocationSize=400)
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_id_seq")
    public int custID;

    public String phonenum;


    public String name;

    public Customer(){

    }

    public Customer(int custID, String phoneNum, String name){

        this.custID = custID;
        this.phonenum = phoneNum;
        this.name = name;

    }
    
}
