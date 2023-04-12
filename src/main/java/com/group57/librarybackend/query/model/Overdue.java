package com.group57.librarybackend.query.model;

public class Overdue {
    public String title;
    public String overDueFee;
    public int productID;
    public Overdue(String id, String overdueFee, int productID){
        this.title = id;
        this.overDueFee = overdueFee;
        this.productID = productID;
    }
}
