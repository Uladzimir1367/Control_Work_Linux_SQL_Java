package Controllers;

import Models.RepositoryImpl;
import Models.AnimalsClasses.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    private final RepositoryImpl repository;

    public AnimalController(RepositoryImpl repository) {
        this.repository = repository;
    }

    public void addAnimal(Animal animal) {
        repository.assignAnimalId(animal);
    }

    public List<Animal> searchAnimal(Integer kind, String name) {
        List<Animal> animals = repository.getAllAnimals();
        List<Animal> foundAnimals = new ArrayList<>();

        for (Animal animal : animals) {
            String animalClass = animal.getClass().getSimpleName();

            if (kind == 1) {
                if (animal.getName().equals(name) && animalClass.equals("Camel")) {
                    foundAnimals.add(animal);
                }
            } else if (kind == 2) {
                if (animal.getName().equals(name) && animalClass.equals("Cat")) {
                    foundAnimals.add(animal);
                }
            } else if (kind == 3) {
                if (animal.getName().equals(name) && animalClass.equals("Dog")) {
                    foundAnimals.add(animal);
                }
            } else if (kind == 4) {
                if (animal.getName().equals(name) && animalClass.equals("Donkey")) {
                    foundAnimals.add(animal);
                }
            } else if (kind == 5) {
                if (animal.getName().equals(name) && animalClass.equals("Hamster")) {
                    foundAnimals.add(animal);
                }
            } else if (kind == 6) {
                if (animal.getName().equals(name) && animalClass.equals("Horse")) {
                    foundAnimals.add(animal);
                }
            }
        }

        return foundAnimals;
    }

    public void addChanges(Animal animal) {
        repository.changeAnimal(animal);
    }
}
