package com.group57.librarybackend.query.model;

import java.io.Serializable;

public class CheckedOutBooksID implements Serializable {
        
    private int bookID;

    private int bookCID;

    public CheckedOutBooksID(){

    }

    public CheckedOutBooksID(int bookID, int bookCID){
        this.bookID = bookID;
        this.bookCID = bookCID;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof CheckedOutBooksID)){
            return false;
        }
        CheckedOutBooksID argument = (CheckedOutBooksID)o;
        return this.bookID == argument.bookID && this.bookCID == argument.bookCID;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if ((Integer)bookID != null) {
            result = 31 * result + bookID;
        }
        if ((Integer)bookCID != null) {
            result = 31 * result + bookCID;
        }
        return result;
    }
}
