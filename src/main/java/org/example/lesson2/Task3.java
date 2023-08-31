package org.example.lesson2;

public class Task3 {
 
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;

            /**
             * Я решил перенести catch (Throwable ex) в самый конец, чтоб он перекрывал 
             * перехват двух первых catch.
             *  И я убрал throws FileNotFoundException у метода printSum так, как
             *  не вижу смысла в этом исключеиив этом месте (метод с файлами не работает)
             */


        }catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }


}
