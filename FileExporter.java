import java.io.FileWriter;
import java.util.ArrayList;

public class FileExporter extends Thread {
    private ArrayList<Student> data;

    public FileExporter(ArrayList<Student> data) {
        this.data = data;
    }

    @Override
    public void run() {
        try (FileWriter writer = new FileWriter("student_export.txt")) {
            for (Student s : data) {
                writer.write(s.toString() + "\n");
            }
            System.out.println("Exported to file successfully!");
        } catch (Exception e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
