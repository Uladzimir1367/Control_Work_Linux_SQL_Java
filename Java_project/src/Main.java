import Models.FileOperations;
import Models.RepositoryImpl;
import Controllers.AnimalController;
import Views.ViewAnimal;

public class Main {
    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations("Animals.csv");
        RepositoryImpl repository = new RepositoryImpl(fileOperations);
        AnimalController controller = new AnimalController(repository);
        ViewAnimal view = new ViewAnimal(controller);

        view.run();
    }
}
