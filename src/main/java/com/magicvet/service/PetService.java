package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {
    private static final String dog_type = "dog";
    private static final String cat_type = "cat";

    public Pet registerNewPet() {
        Pet pet = null;
        System.out.print("Type (dog / cat): ");

        String type = Main.scanner.nextLine();

        if (dog_type.equals(type) || cat_type.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(cat_type)?new Cat():new Dog();
        pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.scanner.nextLine());
        System.out.print("Name: ");
        pet.setName(Main.scanner.nextLine());
        System.out.print("Sex (male / female): ");
        pet.setSex(Main.scanner.nextLine());

        if (type.equals(dog_type)){
            System.out.println("Size (xS / S / M / L / XL): ");
            String size=Main.scanner.nextLine();
            ((Dog)pet).setSize(Dog.Size.valueOf(size));
        }
        return pet;
    }

}
