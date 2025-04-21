public class Admin {
    public void welcome() {
        System.out.println("Welcome Admin!");
    }

    // Polymorphism: method overloading
    public void viewStudent(Student student) {
        System.out.println(student);
    }

    public void viewStudent(String name, int id) {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}
