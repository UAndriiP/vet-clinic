package main.java.com.magicvet;

import java.util.Scanner;

public class Main {
    static String password = "default";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();

    }

    static void run() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.println("Password: ");
            String input = scanner.nextLine();
            if (password.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application hsa been blocked");
    }
}