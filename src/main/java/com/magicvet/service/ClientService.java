package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String email_pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Client registerNewClient() {
        Client client=null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.scanner.nextLine();

        if (inEmailValid(email)) {
            client = buildClient(email);
            System.out.print("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");

        } else {
            System.out.println("Provided email is invalid");
        }
        return client;
    }
    private static Client buildClient(String email) {
        Client client=new Client();
        client.setEmail(email);

        System.out.print("First name: ");
        client.setFirstName(Main.scanner.nextLine());
        System.out.print("Last name: ");
        client.setLastName(Main.scanner.nextLine());
        return client;
    }

    private static boolean inEmailValid(String email) {
        Pattern pattern=Pattern.compile(email_pattern);
        Matcher matcher= pattern.matcher(email);
        return matcher.matches();
    }}
