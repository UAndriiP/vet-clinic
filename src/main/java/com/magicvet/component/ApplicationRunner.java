package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                System.out.print("\nDo you want add your pet now? (y/n): ");
                String addNewPet = Main.scanner.nextLine();
                if (addNewPet.equals("y")) {
                    registerPets(client);
                } else {
                    System.out.println("Thank you for registration, add your pet later!");
                    return;
                }
            }

        }
    }

    private void registerPets(Client client) {
        boolean continueAddsPets = true;
        while (continueAddsPets) {
            addPet(client);
            System.out.print("Do you want to add more pets for the current client? (y/n): ");
            String answer = Main.scanner.nextLine();
            if ("n".equals(answer)) {
                continueAddsPets = false;
            }
        }
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();
        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName((client.getFirstName() + " " + client.getLastName()));
            System.out.println("Pet has been added");
            System.out.println(client);
        }
    }
}