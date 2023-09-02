package org.example.lesson3;


import org.example.lesson3.exceptions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        System.out.println("You have to write:\nLast name, first name, patronymic, birth date, phone number, sex");
        System.out.println("Your note should look like \n\"xxxxxxx xxxxxx xxxxx dd.mm.yyyy xxxxxxxxxx x(only one letter f or m)\"");
        System.out.println("Enter a note:");
        try (Scanner scanner = new Scanner(System.in)) {
            String note = scanner.nextLine();
            NoteParser noteParser = new NoteParser(note);
            System.out.println(noteParser.getNoteForSave());
            try (FileWriter writer = new FileWriter(noteParser.getLastName() + ".txt", true)) {
                writer.write(noteParser.getNoteForSave() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FieldWithLettersNoteException | PhoneNumberNoteException e) {
            System.out.printf("%s\n\"%s\" %s", e.getMessage(), e.getField(), e.getREASON());
        } catch (SexNoteException e) {
            System.out.printf("%s\n\"%s\" doesn't match with \"f\" or \"m\"", e.getMessage(), e.getSex());
        } catch (DataNoteException e) {
            System.out.printf("%s\nYou entered %d params instead %d", e.getMessage(), e.getRealLength(), e.getLengthWhichShouldBe());
        } catch (BirthDateNoteException e) {
            System.out.printf("%s\nCheck you date %s\nMistake is in this param %s", e.getMessage(), e.getField(), e.getSecondField());
        } catch (BirthDateFormatException e) {
            System.out.printf("%s\n%s %s", e.getMessage(), e.getField(), e.getREASON());
        }

    }
}
