package org.example.lesson3.exceptions;

public class FieldWithLettersNoteException extends NoteException{
    private String field;
    private final String REASON = "This field must include only letters!";
    public FieldWithLettersNoteException(String message, String field) {
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
