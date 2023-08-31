package org.example.lesson2;

import java.sql.SQLOutput;
import java.util.Scanner;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class Task4 {

    public static void main(String[] args) {
        System.out.println("Enter a message: ");
        try (Scanner scanner = new Scanner(System.in)) {
       String  message = checkEmptyString(scanner.nextLine());
        } catch (EmptyStringException e){
            System.out.printf("Your message shouldn't be empty! Like this - \"%s\"",e.getStr());
        }
    }

    private static String checkEmptyString(String message) {
        if (message.equals("")) {
            throw new EmptyStringException(message);
        } else {
            return message;
        }
    }
}
