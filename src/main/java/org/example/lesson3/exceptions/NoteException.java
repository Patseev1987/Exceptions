package org.example.lesson3.exceptions;

abstract public class NoteException extends Exception{
    public NoteException(String message) {
        super(message);
    }
    abstract public String getField();
    abstract public String getREASON();
}
