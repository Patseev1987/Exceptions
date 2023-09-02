package org.example.lesson3.exceptions;

public class SexNoteException extends Exception{
    private String sex;
    public SexNoteException(String message,String sex) {
        super(message);
        this.sex=sex;
    }

    public String getSex() {
        return sex;
    }
}
