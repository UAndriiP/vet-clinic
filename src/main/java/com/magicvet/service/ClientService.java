package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String email_pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String name_pattern = "^[a-zA-Z-]{3,}$";

    public Client registerNewClient() {
        Client client = null;

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
        Client client = new Client();
        client.setEmail(email);

        do {
            System.out.print("First name: ");
            client.setFirstName(Main.scanner.nextLine());
            if (!validName(client.getFirstName())) {
                System.out.println("Repeat enter (min 3 symbols)");
            }
        }
        while (!validName(client.getFirstName()));

        do {
            System.out.print("Last name: ");
            client.setLastName(Main.scanner.nextLine());
            if (!validName(client.getLastName())) {
                System.out.println("Repeat enter (min 3 symbols)");
            }
        }
        while (!validName(client.getLastName()));

        System.out.println("Location: ");

        Client.Location location;
        String locationInput = Main.scanner.nextLine();
        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'.Using default value: " + Client.Location.UNKNOWN);
        }
        client.setLocation(location);
        return client;
    }

    private static boolean inEmailValid(String email) {
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validName(String validName) {
        Pattern pattern = Pattern.compile(name_pattern);
        Matcher matcher = pattern.matcher(validName);
        return matcher.matches();
    }
}
