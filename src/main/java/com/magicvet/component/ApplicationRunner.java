package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

import java.util.Scanner;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                System.out.println("\nDo you want add your pet now? y/n");
                String addNewPet = Main.scanner.nextLine();
                if (addNewPet.equals("y")) {
                    System.out.println("Adding a new pet.");

                    Pet pet = petService.registerNewPet();
                    client.setPet(pet);
                    pet.setOwnerName((client.getFirstName() + " " + client.getLastName()));
                    System.out.println("Pet has been added");
                    System.out.println(client);
                } else {
                    System.out.println("Thank you for registration, add your pet later!");
                    return;
                }
            }
        }
    }
}
