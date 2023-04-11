package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    private String title;

    private String director;
    
    private int length;

    private String status;

    private int movieAdminID;

    private String genre;

    private int count;
    
    public Movie(){

    }

    public Movie(int productID, String title, String director, int length, String status, int movieAdminID, String genre, int count){

        this.productID = productID;
        this.title = title;
        this.director = director;
        this.length = length;
        this. status = status;
        this. movieAdminID = movieAdminID;
        this.genre = genre;
        this.count = count;
    }

}
