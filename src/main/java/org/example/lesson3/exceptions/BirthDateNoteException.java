package org.example.lesson3.exceptions;

public class BirthDateNoteException extends BirthDateFormatException {
    private String secondField;
    private final String REASON = "This field must look like this \"dd.mm.yyyy\"";

    public BirthDateNoteException(String message, String field, String secondField) {
        super(message, field);
        this.secondField = secondField;
    }


    public String getREASON() {
        return REASON;
    }

    public String getSecondField() {
        return secondField;
    }
}
