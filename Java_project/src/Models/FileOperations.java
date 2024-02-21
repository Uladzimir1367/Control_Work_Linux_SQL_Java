package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOperations implements FileOperationable {
    private final String filename;

    public FileOperations(String filename) {
        this.filename = filename;

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();

        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            fr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return lines;
    }

    @Override
    public void saveAllLines(List<String> lines) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (String line : lines) {
                writer.write(line);
                writer.append("\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
