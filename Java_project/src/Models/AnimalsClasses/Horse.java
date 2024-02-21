package Models.AnimalsClasses;

import java.util.List;

public class Horse extends PackAnimal {
    public Horse(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Horse(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("HORSE - %s", super.toString());
    }
}
