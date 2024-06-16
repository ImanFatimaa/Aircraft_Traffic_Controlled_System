package oop_project;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Globalclock {
        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Define a format for displaying time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Format and print the current time
        String formattedTime = currentTime.format(formatter);
        public void displaytime() {
        System.out.println("Global Clock Time: " + formattedTime);
        }
}
