package Models;

import java.util.List;

public interface FileOperationable {
    List<String> readAllLines();
    void saveAllLines(List<String> lines);
}
