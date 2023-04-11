package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@IdClass(CheckedOutMoviesID.class)
@Table(name = "checked_out_movies")
public class CheckedOutMovies {

    @Id
    private int movieID;

    @Id
    private int movieCID;

    private String dueDate;

    private String borrowDate;

    private String overDueFee;

    public CheckedOutMovies(){

    }

    public CheckedOutMovies(int movieID, int movieCID, String dueDate, String borrowDate, String overDueFee){
        this.movieID = movieID;
        this.movieCID = movieCID;
        this.dueDate = dueDate;
        this.borrowDate = borrowDate;
        this.overDueFee = overDueFee;
    }
    
}
