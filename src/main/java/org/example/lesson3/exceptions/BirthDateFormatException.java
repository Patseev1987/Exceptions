package org.example.lesson3.exceptions;

public class BirthDateFormatException extends NoteException{
    private String field;

    private final String REASON = "This field must look like this \"dd.mm.yyyy\"";
    public BirthDateFormatException(String message,String field) {
        super(message);
        this.field = field;

    }

    public String getField() {
        return field;
    }

    public String getREASON() {
        return REASON;
    }


}
