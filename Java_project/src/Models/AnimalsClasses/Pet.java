package Models.AnimalsClasses;

import java.util.List;

public class Pet extends Animal {
    public Pet(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Pet(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("pet:\n%s", super.toString());
    }
}
