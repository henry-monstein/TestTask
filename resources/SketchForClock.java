package com.a1qa.testtask.dmitrylishko;

import java.util.Date;



public class Main {

    public static void main(String[] args) {
        Thread clock = new Thread(new Runnable() {
            int TIME_DIFFERENCE_FROM_GREENWICH=3;
            @Override
            public void run() {
                while (true) {
                    Long dateInMiliseconds = new Date().getTime();
                    System.out.print("Day part: ");
                    System.out.print("Night ");
                    System.out.print((dateInMiliseconds / (1000 * 60 * 60)+3) % 24 + " ");
                    System.out.print((dateInMiliseconds / (1000 * 60)) % 60 + " ");
                    System.out.print((dateInMiliseconds / 1000) % 60 + " \r");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                    }
                }
            }
        });
        clock.run();
    }
}
