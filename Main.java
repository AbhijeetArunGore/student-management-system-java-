import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DBHelper db = new DBHelper();
        Admin admin = new Admin();

        admin.welcome();

        while (true) {
            System.out.println("\n1. Add\n2. View\n3. Update\n4. Delete\n5. Export to File\n6. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Name: "); String name = sc.next();
                    System.out.print("Course: "); String course = sc.next();
                    System.out.print("Marks: "); int marks = sc.nextInt();
                    db.insert(new Student(id, name, course, marks));
                    break;
                case 2:
                    for (Student s : db.fetchAll()) System.out.println(s);
                    break;
                case 3:
                    System.out.print("ID to update: "); id = sc.nextInt();
                    System.out.print("New Name: "); name = sc.next();
                    System.out.print("New Course: "); course = sc.next();
                    System.out.print("New Marks: "); marks = sc.nextInt();
                    db.update(id, name, course, marks);
                    break;
                case 4:
                    System.out.print("ID to delete: "); id = sc.nextInt();
                    db.delete(id);
                    break;
                case 5:
                    FileExporter exporter = new FileExporter(db.fetchAll());
                    exporter.start();  // Multithreading
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
