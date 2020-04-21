package com.rs.db.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException (){
        super();
    }

    public DatabaseException (String message){
        super(message);
    }
}
