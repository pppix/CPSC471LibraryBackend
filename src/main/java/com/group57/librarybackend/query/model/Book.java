package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    public String title;

    public String status;

    public int bookAdminID;

    public String genre;

    public String author;

    public int count;
    
    public Book(){

    }

    public Book(int productID, String title, String status, int bookAdminID, String genre, String author, int count){

        this.productID = productID;
        this.title = title;
        this. status = status;
        this. bookAdminID = bookAdminID;
        this.genre = genre;
        this.author = author;
        this.count = count;
    }
    

}
