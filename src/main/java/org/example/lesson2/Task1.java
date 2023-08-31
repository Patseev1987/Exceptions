package org.example.lesson2;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Task1 {
    private static Scanner scanner = new Scanner(System.in);

    public static float getFloat() {
        while (true) {
            float number;
            try {
                System.out.println("Enter a number(float): ");
                String str = scanner.next().trim();
                number = parseFloatToString(str);
                System.out.println("Operation successful");
                return number;
            } catch (ParsingException e) {
                System.out.println("Wrong number! \"" + e.getStr()+ "\" is not float" + " Try again!\n");
            }
        }
    }

    private static float parseFloatToString(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            throw new ParsingException(s);
        }
    }

    public static void main(String[] args) {
       float x =  getFloat();
        System.out.printf("It is your number = %.3f",x);
    }
}
