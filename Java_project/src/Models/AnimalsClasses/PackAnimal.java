package Models.AnimalsClasses;

import java.util.List;

public class PackAnimal extends Animal {
    public PackAnimal(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public PackAnimal(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("pack animal:\n%s", super.toString());
    }
}
