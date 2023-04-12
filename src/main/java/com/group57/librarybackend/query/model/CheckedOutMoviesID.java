package com.group57.librarybackend.query.model;

import java.io.Serializable;

public class CheckedOutMoviesID implements Serializable {
        
    public int movieID;

    public int movieCID;

    public CheckedOutMoviesID(){

    }

    public CheckedOutMoviesID(int movieID, int movieCID){
        this.movieID = movieID;
        this.movieCID = movieCID;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof CheckedOutMoviesID)){
            return false;
        }
        CheckedOutMoviesID argument = (CheckedOutMoviesID)o;
        return this.movieID == argument.movieID && this.movieID == argument.movieCID;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if ((Integer)movieID != null) {
            result = 31 * result + movieID;
        }
        if ((Integer)movieCID != null) {
            result = 31 * result + movieCID;
        }
        return result;
    }
}
