package org.example.lesson2;

public class EmptyStringException extends RuntimeException{
    String str;

    public EmptyStringException(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
