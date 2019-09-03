package com.innowise.testtask.dmitrylishko.controller;

import com.innowise.testtask.dmitrylishko.model.entity.Person;
import com.innowise.testtask.dmitrylishko.view.Printer;
import com.innowise.testtask.dmitrylishko.view.Read;

import java.util.ArrayList;
import java.util.Scanner;

public class TestApp {
    private static final String FILE_NAME = "resources/text.txt";

    public static void main(String[] args) {
        Read rd = new Read();
        Scanner sc = new Scanner(System.in);
        Printer pr = new Printer();
        Menu mn = new Menu();
        int choice = 1;
        while (choice != 0) {
            ArrayList<Person> persons = mn.readPersonsFromFile(FILE_NAME);
            pr.printToConsole("\nWelcome to the person list management program\n" +
                    "Enter:\n" +
                    "1 - to list the console\n" +
                    "2 - to add a new person\n" +
                    "3 - and then the person number to edit it\n" +
                    "4 - and then the person number to delete it\n" +
                    "0 - to exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    mn.printPersonsList(persons.toArray());
                    break;
                }
                case 2: {
                    mn.inputPerson(persons);
                    break;
                }
                case 3: {
                    mn.printPersonsList(persons.toArray());
                    pr.printToConsole("\nEnter the number of the person you want to edit: ");
                    int index = sc.nextInt();
                    mn.changePerson(persons.get(index));
                    break;
                }
                case 4: {
                    pr.printToConsole("\nEnter the number of the person you want to delete: ");
                    int index = sc.nextInt();
                    persons.remove(index);
                    break;
                }
                default: {
                    break;
                }
            }
            mn.writePersonsToFile(FILE_NAME, persons);
        }
    }


}
