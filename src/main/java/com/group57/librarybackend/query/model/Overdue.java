package com.group57.librarybackend.query.model;

public class Overdue {
    public String title;
    public String overDueFee;
    public Overdue(String id, String overdueFee){
        this.title = id;
        this.overDueFee = overdueFee;
    }
}
