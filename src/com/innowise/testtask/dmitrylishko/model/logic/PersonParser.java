package com.innowise.testtask.dmitrylishko.model.logic;

import com.innowise.testtask.dmitrylishko.model.entity.Person;
import com.innowise.testtask.dmitrylishko.view.Read;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonParser {

    public ArrayList<Person> createPersonsFromFile(String fileName) {
        Validator vl = new Validator();
        String[] lines = new Read().readFromFile(fileName);
        ArrayList<Person> persons = new ArrayList<>();
        for (String line : lines) {
            if (vl.isLineValid(line)) {
                Pattern pattern = Pattern.compile(";\\s?");
                String[] parsedLine = pattern.split(line);
                if (vl.isEmail(extractEmail(parsedLine[2])) && vl.isPhones(extractPhones(parsedLine[4]))) {
                    persons.add(new Person(extractName(parsedLine[0]), extractSurname(parsedLine[1]),
                            extractEmail(parsedLine[2]), extractRoles(parsedLine[3]), extractPhones(parsedLine[4])));
                }
            }
        }
        return persons;
    }

    private String extractName(String s) {
        Pattern pattern = Pattern.compile("Name: ");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return s.substring(matcher.end());
        }
        return "";
    }

    private String extractSurname(String s) {
        Pattern pattern = Pattern.compile("Surname: ");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return s.substring(matcher.end());
        }
        return "";
    }

    private String extractEmail(String s) {
        Pattern pattern = Pattern.compile("Email: ");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return s.substring(matcher.end());
        }
        return "";
    }

    private String[] extractRoles(String s) {
        Pattern pattern = Pattern.compile("Roles: ");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            String roles = s.substring(matcher.end() + 1, s.length() - 1);
            Pattern arrayPattern = Pattern.compile(", ");
            return arrayPattern.split(roles);
        }
        return new String[]{};
    }

    private String[] extractPhones(String s) {
        Pattern pattern = Pattern.compile("Phones: ");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            String phones = s.substring(matcher.end() + 1, s.length() - 1);
            Pattern arrayPattern = Pattern.compile(", ");
            return arrayPattern.split(phones);
        }
        return new String[]{};
    }
}
