package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@IdClass(CheckedOutJournalsID.class)
@Table(name = "checked_out_journals")
public class CheckedOutJournals {
    
    @Id
    public int journalID;

    @Id
    private int journalCID;

    public String dueDate;

    public String borrowDate;

    public String overDueFee;

    public CheckedOutJournals(){

    }

    public CheckedOutJournals(int journalID, int journalCID, String dueDate, String borrowDate, String overDueFee){
        this.journalID = journalID;
        this.journalCID = journalCID;
        this.dueDate = dueDate;
        this.borrowDate = borrowDate;
        this.overDueFee = overDueFee;
    }

}
