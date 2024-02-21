package Models.AnimalsClasses;

import java.util.List;

public class Cat extends Pet {
    public Cat(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Cat(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("CAT - %s", super.toString());
    }
}
