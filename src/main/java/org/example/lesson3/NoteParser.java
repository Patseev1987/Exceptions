package org.example.lesson3;

import org.example.lesson3.exceptions.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteParser {
    //Фамилия Имя Отчество датарождения номертелефона пол
    private String[] note;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String birthDate;
    private int phoneNumber;
    private String sex;
    private final int AMOUNT_WORDS = 6;

    public NoteParser(String message) throws DataNoteException, FieldWithLettersNoteException, BirthDateFormatException, PhoneNumberNoteException, SexNoteException {
        note = message.split(" ");
        if (note.length != AMOUNT_WORDS) {
            throw new DataNoteException("You made a mistake in data!", note.length, AMOUNT_WORDS);
        }
        if (checkLetterInString(note[0])) {
            lastName = note[0];
        } else {
            throw new FieldWithLettersNoteException("You made a mistake in last name!", note[0]);
        }
        if (checkLetterInString(note[1])) {
            firstName = note[1];
        } else {
            throw new FieldWithLettersNoteException("You made a mistake in first name!", note[1]);
        }
        if (checkLetterInString(note[2])) {
            patronymic = note[2];
        } else {
            throw new FieldWithLettersNoteException("You made a mistake in patronymic!", note[2]);
        }
        if (checkBirthDate(note[3])) {
            birthDate = note[3];
        }
        if (checkPhoneNumber(note[4])) {
            phoneNumber = Integer.parseInt(note[4]);
        } else {
            throw new PhoneNumberNoteException("You made a mistake in phone number!", note[4]);
        }

        if (note[5].length() == 1 && (note[5].equals("f") || note[5].equals("m"))) {
            sex = note[5];
        } else {
            throw new SexNoteException("You made a mistake in sex!", note[5]);
        }
    }

    private boolean checkBirthDate(String birthDate) throws BirthDateFormatException {
        // датарождения - строка формата dd.mm.yyyy
        Pattern checkBirthDatePattern = Pattern.compile("\\d{1,2}\\.\\d{1,2}\\.\\d{4}");
        Matcher matcher = checkBirthDatePattern.matcher(birthDate);
        if (matcher.matches()){
            String[] temp = birthDate.split("\\.");
            if (temp[1].length()!=2 ||  ((Integer.parseInt(temp[1])<1
                    ||(Integer.parseInt(temp[1])>13)))){
                throw new BirthDateNoteException("You made a mistake in field \"month\"!", birthDate,temp[1]);
            }

            if (temp[2].length()!=4){
                throw new BirthDateNoteException("You made a mistake in field \"year\"!", birthDate,temp[2]);
            }
            int amountDaysInTheYear = Year.of(Integer.parseInt(temp[2])).length();
            int lastDayInMonth = amountDaysInTheYear==366?Month.of(Integer.parseInt(temp[1])).maxLength():Month.of(Integer.parseInt(temp[1])).minLength();
            if (temp[0].length()!=2 || ((Integer.parseInt(temp[0])>lastDayInMonth)
                    || (Integer.parseInt(temp[0])<1))){
                throw new BirthDateNoteException("You made a mistake in field \"day\"!", birthDate,temp[0]);
            }
        }else{
            throw new BirthDateFormatException("You made a mistake in format date!",birthDate);
        }
        return true;
    }

    private boolean checkLetterInString(String lastName) {
        Pattern checkLetterInStringPattern = Pattern.compile("[a-zа-яё]+");
        Matcher matcher = checkLetterInStringPattern.matcher(lastName.toLowerCase());
        return matcher.matches();
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        Pattern x = Pattern.compile("\\d+");
        Matcher matcher = x.matcher(phoneNumber);
        return matcher.matches();
    }

    public String getNoteForSave() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < note.length; i++) {
            sb.append("<");
            sb.append(note[i]);
            sb.append(">");
        }
        return sb.substring(0, sb.length());
    }

    public String getLastName() {
        return lastName;
    }
}
