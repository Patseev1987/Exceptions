package org.example.lesson3.exceptions;

public class DataNoteException extends Exception{
    private int realLength;
    private int lengthWhichShouldBe;

    public int getRealLength() {
        return realLength;
    }

    public int getLengthWhichShouldBe() {
        return lengthWhichShouldBe;
    }

    public DataNoteException(String message, int realLength, int lengthWhichShouldBe) {
        super(message);
        this.realLength = realLength;
        this.lengthWhichShouldBe = lengthWhichShouldBe;
    }

}
