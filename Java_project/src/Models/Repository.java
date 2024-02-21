package Models;

import Models.AnimalsClasses.*;

import java.util.List;

public interface Repository {
    List<Animal> getAllAnimals();
    void assignAnimalId(Animal animal);
    void changeAnimal(Animal animal);
    void saveAnimals(Animal animal);
}
