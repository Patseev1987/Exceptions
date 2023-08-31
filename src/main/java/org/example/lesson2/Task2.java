package org.example.lesson2;

public class Task2 {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6};
        /**
         *Я решил перехватить RuntimeException:
         * 1. у нас имеется ограниченный кусок кода и не понятно
         * чем заполнен массив и его длина
         * 2. В имеющемся catch просто пишется какое исключение мы пеехватывем,
         * я решил что в этой ситуации можно перехватывать любые не проверяемые исключения
         */
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (RuntimeException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}