package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "movie")
@SequenceGenerator(name="movie_id_seq", initialValue=102, allocationSize=98)
public class Movie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movie_id_seq")
    public int productID;

    public String title;

    public String director;
    
    public int length;

    public String status;

    public int movieadminid;

    public String genre;

    public int count;
    
    public Movie(){

    }

    public Movie(int productID, String title, String director, int length, String status, int movieAdminID, String genre, int count){

        this.productID = productID;
        this.title = title;
        this.director = director;
        this.length = length;
        this. status = status;
        this. movieadminid = movieAdminID;
        this.genre = genre;
        this.count = count;
    }

}
