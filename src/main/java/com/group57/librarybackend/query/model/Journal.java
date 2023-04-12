package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "journal")
public class Journal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    public String title;

    private String status;

    private int journalAdminID;

    private String genre;

    private String author;

    private int count;
    
    public Journal(){

    }

    public Journal(int productID, String title, String status, int journalAdminID, String genre, String author, int count){

        this.productID = productID;
        this.title = title;
        this. status = status;
        this. journalAdminID = journalAdminID;
        this.genre = genre;
        this.author = author;
        this.count = count;
    }

}
