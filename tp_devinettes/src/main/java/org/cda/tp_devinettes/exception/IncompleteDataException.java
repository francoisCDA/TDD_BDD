package org.cda.tp_devinettes.exception;

public class IncompleteDataException extends Exception {

    public IncompleteDataException(String missingData) {
        super("need " + missingData + "argument");
    }

}
