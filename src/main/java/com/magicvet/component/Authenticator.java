package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;

public class Authenticator {

    private final static String password = "a";

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = Main.scanner.nextLine();
            if (password.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked");
        return accepted;
    }
}
