package org.cda.tp_devinettes.exception;

public class DataBaseException extends Exception {
    public DataBaseException(String dataBaseError){
        super(dataBaseError);
    }
}
