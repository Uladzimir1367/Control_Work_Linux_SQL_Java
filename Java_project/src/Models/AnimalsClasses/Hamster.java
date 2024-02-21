package Models.AnimalsClasses;

import java.util.List;

public class Hamster extends Pet {
    public Hamster(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Hamster(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("HAMSTER - %s", super.toString());
    }
}
