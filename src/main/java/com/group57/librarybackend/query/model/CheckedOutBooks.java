package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "checked_out_books")
public class CheckedOutBooks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookCID;

    private String dueDate;

    private String borrowDate;

    private String overDueFee;

    public CheckedOutBooks(){

    }

    public CheckedOutBooks(int bookID, int bookCID, String dueDate, String borrowDate, String overDueFee){
        this.bookID = bookID;
        this.bookCID = bookCID;
        this.dueDate = dueDate;
        this.borrowDate = borrowDate;
        this.overDueFee = overDueFee;
    }

}
