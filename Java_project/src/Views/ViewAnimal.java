package Views;

import Controllers.AnimalController;
import Models.AnimalsClasses.*;
import Models.Counter;

import java.util.InputMismatchException;
import java.util.List;

public class ViewAnimal {
    private final UserInterface ui = new UserInterface();
    private final AnimalController controller;

    public ViewAnimal(AnimalController controller) {
        this.controller = controller;
    }

    public void run() {
        ui.hello();

        try (Counter counter = new Counter(0)) {
            while (true) {
                ui.mainMenu();
                try {
                    int answer = ui.prompt("Enter number: ");
                    switch (answer) {
                        case 1 -> addNewAnimal(counter);
                        case 2 -> showAnimalCommands();
                        case 3 -> addNewAnimalCommands();
                        case 4 -> {
                            System.out.println("=====================================");
                            System.out.println("The program has completed!");
                            System.out.println(counter);
                            System.out.println("=====================================");
                            return;
                        }
                        default -> {
                            System.out.println("=====================================");
                            System.out.println("Enter number from the list!");
                            System.out.println("=====================================");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("=====================================");
                    System.out.println("ERROR! Enter only numbers!");
                    System.out.println("=====================================");
                } catch (Exception ex) {
                    System.out.println("=====================================");
                    System.out.println(ex.getMessage());
                    System.out.println("=====================================");
                }
            }
        } catch (Exception ex) {
            System.out.println("=====================================");
            System.out.println(ex.getMessage());
            System.out.println("=====================================");
        }
    }

    private void addNewAnimal(Counter counter) throws Exception {
        Integer kind = ui.chooseKind();
        if (kind == null) {
            return;
        }

        String name = ui.inputName();
        if (name == null) {
            return;
        }

        String birthday = ui.inputBirthday();
        if (birthday == null) {
            return;
        }

        List<String> commands = ui.inputCommands();

        System.out.println();
        System.out.println("=====================================");
        System.out.println("Added a new animal to the registry:");
        System.out.println("=====================================");

        switch (kind) {
            case 1 -> {
                Camel camel = new Camel(name, birthday, commands);
                controller.addAnimal(camel);
                System.out.println(camel);
                counter.add();
            }
            case 2 -> {
                Cat cat = new Cat(name, birthday, commands);
                controller.addAnimal(cat);
                System.out.println(cat);
                counter.add();
            }
            case 3 -> {
                Dog dog = new Dog(name, birthday, commands);
                controller.addAnimal(dog);
                System.out.println(dog);
                counter.add();
            }
            case 4 -> {
                Donkey donkey = new Donkey(name, birthday, commands);
                controller.addAnimal(donkey);
                System.out.println(donkey);
                counter.add();
            }
            case 5 -> {
                Hamster hamster = new Hamster(name, birthday, commands);
                controller.addAnimal(hamster);
                System.out.println(hamster);
                counter.add();
            }
            case 6 -> {
                Horse horse = new Horse(name, birthday, commands);
                controller.addAnimal(horse);
                System.out.println(horse);
                counter.add();
            }
        }
    }

    private void showAnimalCommands() throws Exception {
        Integer kind = ui.chooseKind();
        if (kind == null) {
            return;
        }

        String name = ui.inputName();
        if (name == null) {
            return;
        }

        List<Animal> foundAnimals = controller.searchAnimal(kind, name);
        Animal animal = ui.showFoundAnimal(foundAnimals);
        List<String> commands = animal.getCommands();

        if (commands != null) {
            StringBuilder sb = new StringBuilder();

            for (String command : commands) {
                sb.append(command);
                sb.append(", ");
            }

            int len = sb.length();
            sb.delete(len - 2, len - 1);

            System.out.println();
            System.out.println("=========================================");
            System.out.printf("%s knows next commands: %s\n", animal.getName(), sb);
            System.out.println("=========================================");
        } else {
            System.out.println();
            System.out.println("=========================================");
            System.out.println("This animal does not know any commands!");
            System.out.println("=========================================");
        }
    }

    private void addNewAnimalCommands() throws Exception {
        Integer kind = ui.chooseKind();
        if (kind == null) {
            return;
        }

        String name = ui.inputName();
        if (name == null) {
            return;
        }

        List<Animal> foundAnimals = controller.searchAnimal(kind, name);
        Animal animal = ui.showFoundAnimal(foundAnimals);
        List<String> commands = animal.getCommands();
        List<String> newCommands = ui.addNewCommand(commands);
        animal.setCommands(newCommands);

        controller.addChanges(animal);
        System.out.println("CHANGES ADDED.");
        System.out.println(animal);
        System.out.println();
    }
}
