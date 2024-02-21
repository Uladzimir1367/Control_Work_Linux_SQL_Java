package Models.AnimalsClasses;

import java.util.List;

public class Animal {
    private String id;
    private String name;
    private String birthday;
    private List<String> commands;

    public Animal(String name, String birthday, List<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public Animal(String id, String name, String birthday, List<String> commands) {
        this(name, birthday, commands);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        if (commands != null) {
            StringBuilder sb = new StringBuilder();
            for (String command : commands) {
                sb.append(command);
                sb.append(", ");
            }

            int len = sb.length();
            sb.delete(len - 2, len - 1);

            return String.format("""
                    ID: %s, Name: %s, Birthday: %s
                    This animal knows next commands:
                    %s""", id, name, birthday, sb);
        } else {
            return String.format("""
                    ID: %s, Name: %s, Birthday: %s
                    This animal does not know any commands.
                    """, id, name, birthday);
        }
    }
}
