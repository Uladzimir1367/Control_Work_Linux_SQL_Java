package Models;

import Models.AnimalsClasses.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalMapper {
    public String map(Animal animal) {
        List<String> commands = animal.getCommands();

        if (commands != null) {
            StringBuilder sb = new StringBuilder();

            for (String command : commands) {
                sb.append(command);
                sb.append("/");
            }

            sb.deleteCharAt(sb.length() - 1);

            return String.format("%s;%s;%s;%s;%s",
                    animal.getId(),
                    animal.getClass().getSimpleName(),
                    animal.getName(),
                    animal.getBirthday(),
                    sb);
        } else {
            return String.format("%s;%s;%s;%s;%s",
                    animal.getId(),
                    animal.getClass().getSimpleName(),
                    animal.getName(),
                    animal.getBirthday(),
                    null);
        }
    }

    public Animal map(String line) {
        String[] data = line.split(";");
        String commands = data[4];

        if (!commands.equals("null")) {
            String[] commandsSplit = commands.split("/");
            List<String> commandsList = new ArrayList<>(Arrays.asList(commandsSplit));

            return switch (data[1]) {
                case "Camel" -> new Camel(data[0], data[2], data[3], commandsList);
                case "Cat" -> new Cat(data[0], data[2], data[3], commandsList);
                case "Dog" -> new Dog(data[0], data[2], data[3], commandsList);
                case "Donkey" -> new Donkey(data[0], data[2], data[3], commandsList);
                case "Hamster" -> new Hamster(data[0], data[2], data[3], commandsList);
                case "Horse" -> new Horse(data[0], data[2], data[3], commandsList);
                default -> new Animal(data[0], data[2], data[3], commandsList);
            };
        } else {
            return switch (data[1]) {
                case "Camel" -> new Camel(data[0], data[2], data[3], null);
                case "Cat" -> new Cat(data[0], data[2], data[3], null);
                case "Dog" -> new Dog(data[0], data[2], data[3], null);
                case "Donkey" -> new Donkey(data[0], data[2], data[3], null);
                case "Hamster" -> new Hamster(data[0], data[2], data[3], null);
                case "Horse" -> new Horse(data[0], data[2], data[3], null);
                default -> new Animal(data[0], data[2], data[3], null);
            };
        }
    }
}
