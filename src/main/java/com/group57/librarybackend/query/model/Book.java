package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "book")
@SequenceGenerator(name="book_id_seq", initialValue=3, allocationSize=96)
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_id_seq")
    public int productID;

    
    @Column(name = "Title")
    public String title;

    @Column(name = "Status")
    public String status;

    @JoinColumn(name = "BookAdminID")
    public int bookadminid;

    @Column(name = "Genre")
    public String genre;

    @Column(name = "Author")
    public String author;

    @Column(name = "Count")
    public int count;
    
    public Book(){

    }

    public Book(int productID, String title, String status, int bookAdminID, String genre, String author, int count){

        this.productID = productID;
        this.title = title;
        this.status = status;
        this.bookadminid = bookAdminID;
        this.genre = genre;
        this.author = author;
        this.count = count;
    }
    

}
