package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String password = "a";
    static Scanner scanner = new Scanner(System.in);

    static String email_pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String name_pattern = "^[a-zA-Z-]{3,}$";

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = scanner.nextLine();
            if (password.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application hsa been blocked");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (inEmailValid(email)) {
            Client client = buildClient(email);
            System.out.println("New client: " + client.firstName.toUpperCase() + " " + client.lastName.toUpperCase() + " (" + client.email + ")");

        } else {
            System.out.println("Provided email is invalid");
        }
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        do {
            System.out.print("First name: ");
            client.firstName = scanner.nextLine();
            if (!validName(client.firstName)) {
                System.out.println("Wrong format (min 3 symbols)");
            }
        }
        while (!validName(client.firstName));

        do {
            System.out.print("Last name: ");
            client.lastName = scanner.nextLine();
            if (!validName(client.lastName)) {
                System.out.println("Wrong format (min 3 symbols)");
            }
        }
        while (!validName(client.lastName));

        return client;
    }

    static boolean inEmailValid(String email) {
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean validName(String validName) {
        Pattern pattern = Pattern.compile(name_pattern);
        Matcher matcher = pattern.matcher(validName);
        return matcher.matches();
    }

}