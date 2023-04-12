package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "journal")
@SequenceGenerator(name="journal_id_seq", initialValue=202, allocationSize=98)
public class Journal {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="journal_id_seq")
    public int productID;

    public String title;

    public String status;

    public int journaladminid;

    public String genre;

    public String author;

    public int count;
    
    public Journal(){

    }

    public Journal(int productID, String title, String status, int journalAdminID, String genre, String author, int count){

        this.productID = productID;
        this.title = title;
        this. status = status;
        this. journaladminid = journalAdminID;
        this.genre = genre;
        this.author = author;
        this.count = count;
    }

}
