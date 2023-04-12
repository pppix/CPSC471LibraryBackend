package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@IdClass(CheckedOutJournalsID.class)
@Table(name = "checked_out_journals")
public class CheckedOutJournals {
    
    @Id
    public int journalID;

    @Id
    public int journalCID;

    public String duedate;

    public String borrowdate;

    public String overduefee;

    public CheckedOutJournals(){

    }

    public CheckedOutJournals(int journalID, int journalCID, String dueDate, String borrowDate, String overDueFee){
        this.journalID = journalID;
        this.journalCID = journalCID;
        this.duedate = dueDate;
        this.borrowdate = borrowDate;
        this.overduefee = overDueFee;
    }

}
