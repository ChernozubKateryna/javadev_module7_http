package com.goit.feature;

import com.goit.feature.downloader.HttpStatusImageDownloader;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        System.out.println("Enter HTTP status code:");

        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        if (isValidInput(inputNumber)) {
            try {
                downloader.downloadStatusImage(Integer.parseInt(inputNumber));
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Invalid number! Please enter valid number.");
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
