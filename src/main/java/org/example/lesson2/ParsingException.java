package org.example.lesson2;

public class ParsingException extends RuntimeException{
    private String str;

    public ParsingException(String string) {
        this.str = string;
    }

    public String getStr() {
        return str;
    }
}
