package Views;

import Exceptions.*;
import Models.AnimalsClasses.Animal;

import java.util.*;

public class UserInterface {
    private final Validate validate = new Validate();

    public void hello() {
        System.out.println("=========================================");
        System.out.println("WELCOME TO ANIMAL REGISTRY!");
        System.out.println("=========================================");
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("Choose the item from the list: ");
        System.out.println("""
                1. Add new animal
                2. Show animal's commands
                3. Teach animal new command
                4. Exit""");
        System.out.println();
    }

    public void animalKind() {
        System.out.println();
        System.out.println("Choose the item from the list: ");
        System.out.println("""
                1. Camel
                2. Cat
                3. Dog
                4. Donkey
                5. Hamster
                6. Horse
                0. Cancel""");
        System.out.println();
    }

    public int prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextInt();
    }

    public String print(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    public Integer chooseKind() {
        while (true) {
            animalKind();
            try {
                int answer = prompt("Enter number: ");
                if (answer == 0) {
                    System.out.println();
                    System.out.println("=========================================");
                    System.out.println("You canceled the input.");
                    System.out.println("=========================================");
                    System.out.println();
                    return null;
                } else if (answer < 1 || answer > 6) {
                    System.out.println("=====================================");
                    System.out.println("Enter number from the list!");
                    System.out.println("=====================================");
                } else {
                    return answer;
                }
            } catch (InputMismatchException ex) {
                System.out.println("=====================================");
                System.out.println("ERROR! Enter only numbers!");
                System.out.println("=====================================");
            }
        }
    }

    public String inputName() throws Exception {
        while (true) {
            try {
                System.out.println();
                String name = print("Enter animal's name (enter 'q' to refuse): ");
                if (name.equalsIgnoreCase("q")) {
                    System.out.println();
                    System.out.println("=========================================");
                    System.out.println("You interrupted the input.");
                    System.out.println("=========================================");
                    System.out.println();
                    return null;
                }
                validate.checkString(name);
                return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            } catch (EmptyInputException | LengthException | IntException ex) {
                System.out.println("=========================================");
                System.out.println(ex.getMessage());
                System.out.println("=========================================");
            }
        }
    }

    public String inputBirthday() throws Exception {
        while (true) {
            try {
                System.out.println();
                String birthday = print("Enter animal's birthday in format dd.mm.yyyy (enter 'q' to refuse): ");
                if (birthday.equalsIgnoreCase("q")) {
                    System.out.println();
                    System.out.println("=========================================");
                    System.out.println("You interrupted the input.");
                    System.out.println("=========================================");
                    System.out.println();
                    return null;
                }
                validate.checkDateFormat(birthday);
                validate.checkBirthday(birthday);
                return birthday;
            } catch (DateFormatException | DateException ex) {
                System.out.println("=========================================");
                System.out.println(ex.getMessage());
                System.out.println("=========================================");
            }
        }
    }

    public List<String> inputCommands() throws Exception {
        List<String> commands = new ArrayList<>();

        while (true) {
            System.out.println();
            String answer = print("Does this animal know any commands? Enter 'yes' or 'no': ");
            if (answer.equalsIgnoreCase("no")) {
                return null;
            } else if (answer.equalsIgnoreCase("yes")) {
                while (true) {
                    try {
                        String commandsString = print("Enter commands separated by space: ");
                        validate.checkString(commandsString);
                        String[] commandsList = commandsString.split(" ");

                        Collections.addAll(commands, commandsList);

                        return commands;
                    } catch (EmptyInputException | LengthException | IntException ex) {
                        System.out.println("=========================================");
                        System.out.println(ex.getMessage());
                        System.out.println("=========================================");
                    }
                }
            } else {
                System.out.println("=========================================");
                System.out.println("Enter 'yes' or 'no'!");
                System.out.println("=========================================");
            }
        }
    }

    public List<Integer> showFoundAnimals(List<Animal> animals) throws Exception {
        try {
            validate.searchAnimal(animals);

            System.out.println();
            System.out.println("=========================================");
            System.out.println("Were found next animals: ");
            System.out.println("=========================================");

            List<Integer> animalsId = new ArrayList<>();

            for (Animal animal : animals) {
                int animalId = Integer.parseInt(animal.getId());
                animalsId.add(animalId);

                System.out.println(animal);
                System.out.println();
            }

            return animalsId;
        } catch (NotFoundException ex) {
            System.out.println("=========================================");
            System.out.println(ex.getMessage());
            System.out.println("=========================================");
        }

        return null;
    }

    public Animal showFoundAnimal(List<Animal> animals) throws Exception {
        List<Integer> animalsId = showFoundAnimals(animals);

        while (true) {
            try {
                int animalId = prompt("Enter animal id: ");

                for (Integer id : animalsId) {
                    if (animalId == id) {
                        for (Animal animal : animals) {
                            if (Integer.parseInt(animal.getId()) == animalId) {
                                return animal;
                            }
                        }
                    }
                }
                System.out.println("=====================================");
                System.out.println("Enter id from the list above!");
                System.out.println("=====================================");
                System.out.println();
            } catch (InputMismatchException ex) {
                System.out.println("=====================================");
                System.out.println("ERROR! Enter only numbers!");
                System.out.println("=====================================");
            }
        }
    }

    public List<String> addNewCommand(List<String> commands) throws Exception {
        while (true) {
            try {
                System.out.println();
                String command = print("Enter new command (enter 'q' to finish): ");
                if (command.equalsIgnoreCase("q")) {
                    System.out.println();
                    System.out.println("=========================================");
                    System.out.println("You have completed the input.");
                    System.out.println("=========================================");
                    System.out.println();
                    return commands;
                }

                validate.checkString(command);

                if (commands == null) {
                    commands = new ArrayList<>();
                }
                commands.add(command);
            } catch (EmptyInputException | LengthException | IntException ex) {
                System.out.println("=========================================");
                System.out.println(ex.getMessage());
                System.out.println("=========================================");
            }
        }
    }
}
