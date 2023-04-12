package com.group57.librarybackend.query.model;

import java.io.Serializable;

public class DependantID implements Serializable {
    
    public int EID;

    public String firstname;

    public DependantID(){

    }

    public DependantID(int EID, String firstName){
        this.EID = EID;
        this.firstname = firstName;
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
        boolean firstNameEquals = (this.firstname == null && argument.firstname == null) || (this.firstname != null && this.firstname.equals(argument.firstname));
        return this.EID == argument.EID && firstNameEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if ((Integer)EID != null) {
            result = 31 * result + EID;
        }
        if (firstname != null) {
            result = 31 * result + firstname.hashCode();
        }
        return result;
    }
}
