package com.group57.librarybackend.query.model;

public class Overdue {
    private String title;
    private String overDueFee;
    public Overdue(String id, String overdueFee){
        this.title = id;
        this.overDueFee = overdueFee;
    }
}
