package com.group57.librarybackend.query.model;

import java.io.Serializable;

public class DependantID implements Serializable {
    
    private int EID;

    private String firstName;

    public DependantID(){

    }

    public DependantID(int EID, String firstName){
        this.EID = EID;
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof DependantID)){
            return false;
        }
        DependantID argument = (DependantID)o;
        boolean firstNameEquals = (this.firstName == null && argument.firstName == null) || (this.firstName != null && this.firstName.equals(argument.firstName));
        return this.EID == argument.EID && firstNameEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if ((Integer)EID != null) {
            result = 31 * result + EID;
        }
        if (firstName != null) {
            result = 31 * result + firstName.hashCode();
        }
        return result;
    }
}
