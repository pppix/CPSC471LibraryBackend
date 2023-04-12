package com.group57.librarybackend.query.model;

import java.io.Serializable;

public class CheckedOutJournalsID implements Serializable {
        
    public int journalID;

    public int journalCID;

    public CheckedOutJournalsID(){

    }

    public CheckedOutJournalsID(int journalID, int journalCID){
        this.journalID = journalID;
        this.journalCID = journalCID;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof CheckedOutJournalsID)){
            return false;
        }
        CheckedOutJournalsID argument = (CheckedOutJournalsID)o;
        return this.journalID == argument.journalID && this.journalCID == argument.journalCID;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if ((Integer)journalID != null) {
            result = 31 * result + journalID;
        }
        if ((Integer)journalCID != null) {
            result = 31 * result + journalCID;
        }
        return result;
    }
}
