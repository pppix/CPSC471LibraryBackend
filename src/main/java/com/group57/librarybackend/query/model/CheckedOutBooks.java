package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@IdClass(CheckedOutBooksID.class)
@Table(name = "checked_out_books")
public class CheckedOutBooks {
    
    @Id
    public int bookID;

    @Id
    public int bookCID;
    public String duedate;

    public String borrowdate;

    public String overduefee;

    public CheckedOutBooks(){

    }

    public CheckedOutBooks(int bookID, int bookCID, String dueDate, String borrowDate, String overDueFee){
        this.bookID = bookID;
        this.bookCID = bookCID;
        this.duedate = dueDate;
        this.borrowdate = borrowDate;
        this.overduefee = overDueFee;
    }

}
