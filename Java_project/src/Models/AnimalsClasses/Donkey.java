package Models.AnimalsClasses;

import java.util.List;

public class Donkey extends PackAnimal {
    public Donkey(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Donkey(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("DONKEY - %s", super.toString());
    }
}
