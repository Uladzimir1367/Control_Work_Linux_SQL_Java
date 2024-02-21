package Models.AnimalsClasses;

import java.util.List;

public class Camel extends PackAnimal {
    public Camel(String name, String birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    public Camel(String id, String name, String birthday, List<String> commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public String toString() {
        return String.format("CAMEL - %s", super.toString());
    }
}
