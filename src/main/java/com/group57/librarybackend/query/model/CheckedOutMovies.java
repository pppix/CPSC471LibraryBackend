package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@IdClass(CheckedOutMoviesID.class)
@Table(name = "checked_out_movies")
public class CheckedOutMovies {

    @Id
    public int movieID;

    @Id
    public int movieCID;

    public String duedate;

    public String borrowdate;

    public String overduefee;


    public CheckedOutMovies(){

    }

    public CheckedOutMovies(int movieID, int movieCID, String dueDate, String borrowDate, String overDueFee){
        this.movieID = movieID;
        this.movieCID = movieCID;
        this.duedate = dueDate;
        this.borrowdate = borrowDate;
        this.overduefee = overDueFee;
    }
    
}
