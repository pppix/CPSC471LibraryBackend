package com.group57.librarybackend.query.model;

import jakarta.persistence.*; // import jakarta.persistence.*; // for SpringBoot 3

@Entity
@Table(name = "checked_out_journals")
public class CheckedOutJournals {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int journalID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int journalCID;

    private String dueDate;

    private String borrowDate;

    private String overDueFee;

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
