package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "journal")
public class Journal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int productID;

    public String title;

    public String status;

    public int journalAdminID;

    public String genre;

    public String author;

    public int count;
    
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
