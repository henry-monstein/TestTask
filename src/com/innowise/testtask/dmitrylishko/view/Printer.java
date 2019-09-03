package com.innowise.testtask.dmitrylishko.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Printer {

    public void printToFile(String fileName, String... messages) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (String m : messages) {
                writer.write(m + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> void printToFile(String fileName, ArrayList<T> messages) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (T m : messages) {
                writer.write(m.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printToConsole(String message) {
        System.out.println(message);
    }
}
