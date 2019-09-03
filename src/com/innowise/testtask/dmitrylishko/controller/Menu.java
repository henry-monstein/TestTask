package com.innowise.testtask.dmitrylishko.controller;

import com.innowise.testtask.dmitrylishko.model.entity.Person;
import com.innowise.testtask.dmitrylishko.model.logic.PersonParser;
import com.innowise.testtask.dmitrylishko.model.logic.Validator;
import com.innowise.testtask.dmitrylishko.view.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public ArrayList<Person> readPersonsFromFile(String fileName) {
        ArrayList<Person> persons = new PersonParser().createPersonsFromFile(fileName);
        return persons;
    }

    public void writePersonsToFile(String fileName, ArrayList<Person> persons) {
        new Printer().printToFile(fileName, persons);
    }

    public void printPersonsList(Object[] persons) {
        Printer pr = new Printer();
        for (int i = 0; i < persons.length; i++) {
            pr.printToConsole(i + " " + persons[i].toString());
        }
    }

    public void changePerson(Person person) {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        pr.printToConsole(person.toString());
        int choice = 1;
        while (choice != 0) {
            pr.printToConsole("\nEnter: \n" +
                    "1 - to change the name\n" +
                    "2 - to change last name\n" +
                    "3 - to change the email\n" +
                    "4 - to change the role\n" +
                    "5 - to change the phone\n" +
                    "0 - to exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    pr.printToConsole("Current name: " + person.getName());
                    person.setName(inputName());
                    break;
                }
                case 2: {
                    pr.printToConsole("Current surname: " + person.getSurname());
                    person.setSurname(inputSurname());
                    break;
                }
                case 3: {
                    pr.printToConsole("Current email: " + person.getEmail());
                    person.setEmail(inputEmail());
                    break;
                }
                case 4: {
                    person.setRoles(changeRoles(person.getRoles()));
                    break;
                }
                case 5: {
                    person.setPhones(changePhones(person.getPhones()));
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private String inputName() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        String name = "";
        int choice = 0;
        while (choice != 1) {
            pr.printToConsole("\nEnter name: ");
            name = sc.next();
            pr.printToConsole("\nYou entered this name: " + name + "\n" +
                    "Would you like to continue(1) or re-enter(0)");
            choice = sc.nextInt();
        }
        return name;
    }

    private String inputSurname() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        String surname = "";
        int choice = 0;
        while (choice != 1) {
            pr.printToConsole("\nEnter surname: ");
            surname = sc.next();
            pr.printToConsole("\nYou entered this surname: " + surname + "\n" +
                    "Would you like to continue(1) or re-enter(0)");
            choice = sc.nextInt();
        }
        return surname;
    }

    private String inputEmail() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        Validator vl = new Validator();
        String email = "";
        int choice = 0;
        while (choice != 1) {
            pr.printToConsole("\nEnter the email in the correct format (********@*****.***): ");
            while (!vl.isEmail(email)) {
                email = sc.next();
            }
            pr.printToConsole("\nYou entered this email: " + email + "\n" +
                    "Would you like to continue(1) or re-enter(0)");
            choice = sc.nextInt();
        }
        return email;
    }

    private String[] inputRoles() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> roles = new ArrayList<>();
        int choice = 0;
        while (choice != 1) {
            if (roles.size() <= 3) {
                roles.add(inputRole());
                pr.printToConsole("Continue(1) or add another role(0)");
                choice = sc.nextInt();
            } else {
                choice = 1;
            }
        }
        return roles.toArray(new String[roles.size()]);
    }

    private String[] changeRoles(String[] roles) {
        ArrayList<String> newRoles = new ArrayList<>(Arrays.asList(roles));
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            for (int i = 0; i < newRoles.size(); i++) {
                pr.printToConsole(i + " - " + newRoles.get(i));
            }
            pr.printToConsole("\nEnter: \n" +
                    "1 - to add a role (3 maximum)\n" +
                    "2 - and the role number to change it\n" +
                    "3 - and the role number to delete it\n" +
                    "0 - to exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    if (newRoles.size() <= 3) {
                        newRoles.add(inputRole());
                    }
                    break;
                }
                case 2: {
                    int index = sc.nextInt();
                    pr.printToConsole("Current role: " + newRoles.get(index));
                    newRoles.set(index, inputRole());
                }
                case 3: {
                    int index = sc.nextInt();
                    newRoles.remove(index);
                }
                default: {
                    break;
                }
            }
        }
        return newRoles.toArray(new String[newRoles.size()]);
    }

    private String inputRole() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        String role = "";
        int choice = 0;
        while (choice != 1) {
            pr.printToConsole("\nEnter role: ");
            role = sc.next();
            pr.printToConsole("\nYou entered this role: " + role + "\n" +
                    "Would you like to continue(1) or re-enter(0)");
            choice = sc.nextInt();
        }
        return role;
    }

    private String[] inputPhones() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> phones = new ArrayList<>();
        int choice = 0;
        while (choice != 1) {
            if (phones.size() <= 3) {
                phones.add(inputPhone());
                pr.printToConsole("Continue(1) or add another phone(0)");
                choice = sc.nextInt();
            } else {
                choice = 1;
            }
        }
        return phones.toArray(new String[phones.size()]);
    }

    private String[] changePhones(String[] phones) {
        ArrayList<String> newPhones = new ArrayList<String>(Arrays.asList(phones));
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            for (int i = 0; i < newPhones.size(); i++) {
                pr.printToConsole(i + " - " + newPhones.get(i));
            }
            pr.printToConsole("\nEnter: " +
                    "1 - to add a phone (3 maximum)\n" +
                    "2 - and the phone number to change it\n" +
                    "3 - and the phone number to delete it\n" +
                    "0 - to exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    if (newPhones.size() <= 3) {
                        newPhones.add(inputPhone());
                    }
                    break;
                }
                case 2: {
                    int index = sc.nextInt();
                    pr.printToConsole("Current role: " + newPhones.get(index));
                    newPhones.set(index, inputRole());
                }
                case 3: {
                    int index = sc.nextInt();
                    newPhones.remove(index);
                }
                default: {
                    break;
                }
            }
        }
        return newPhones.toArray(new String[newPhones.size()]);
    }

    private String inputPhone() {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        Validator vl = new Validator();
        String phone = "";
        int choice = 0;
        while (choice != 1) {
            pr.printToConsole("\nEnter the phone in the format 375** *******: ");
            while (!vl.isPhone(phone)) {
                phone = sc.nextLine();
            }
            pr.printToConsole("\nYou entered this phone: " + phone + "\n" +
                    "Would you like to continue(1) or re-enter(0)");
            choice = sc.nextInt();
        }
        return phone;
    }

    public void inputPerson(ArrayList<Person> persons) {
        String name = inputName();
        String surname = inputSurname();
        String email = inputEmail();
        String[] roles = inputRoles();
        String[] phones = inputPhones();
        persons.add(new Person(name, surname, email, roles, phones));
    }
}
