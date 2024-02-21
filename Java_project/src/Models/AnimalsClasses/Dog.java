package Models.AnimalsClasses;

import java.util.List;

public class Dog extends Pet {
    public Dog(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Dog(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("DOG - %s", super.toString());
    }
}
