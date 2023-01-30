package com.goit.feature;

import com.goit.feature.downloader.HttpStatusImageDownloader;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        System.out.println("Enter 'exit' when you want to stop the program. \nEnter HTTP status code:");

        while(true) {
            Scanner scanner = new Scanner(System.in);
            String inputNumber = scanner.nextLine();

            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

            if (inputNumber.equals("exit")) {
                return;
            }

            if (isValidInput(inputNumber)) {
                    try {
                        downloader.downloadStatusImage(Integer.parseInt(inputNumber));
                    } catch (IOException | InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } else{
                    System.out.println("Invalid input! Please enter valid number.");
                }
        }
    }

    private static boolean isValidInput(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
