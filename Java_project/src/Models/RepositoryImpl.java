package Models;

import Models.AnimalsClasses.Animal;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private final AnimalMapper mapper = new AnimalMapper();
    private final FileOperations fileOperations;

    public RepositoryImpl(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    @Override
    public List<Animal> getAllAnimals() {
        List<String> lines = fileOperations.readAllLines();
        List<Animal> animals = new ArrayList<>();

        for (String line : lines) {
            animals.add(mapper.map(line));
        }

        return animals;
    }

    @Override
    public void assignAnimalId(Animal animal) {
        List<Animal> animals = getAllAnimals();
        int max = 0;

        for (Animal an : animals) {
            int id = Integer.parseInt(an.getId());
            if (max < id) {
                max = id;
            }
        }

        int newId = max + 1;
        String id = String.format("%d", newId);
        animal.setId(id);
        animals.add(animal);

        List<String> lines = new ArrayList<>();
        for (Animal an : animals) {
            lines.add(mapper.map(an));
        }

        fileOperations.saveAllLines(lines);
    }

    @Override
    public void changeAnimal(Animal animal) {
        saveAnimals(animal);
    }

    @Override
    public void saveAnimals(Animal animal) {
        List<Animal> animals = getAllAnimals();
        List<String> lines = new ArrayList<>();

        for (Animal an : animals) {
            if (animal.getId().equals(an.getId())) {
                lines.add(mapper.map(animal));
            } else {
                lines.add(mapper.map(an));
            }
        }

        fileOperations.saveAllLines(lines);
    }
}
