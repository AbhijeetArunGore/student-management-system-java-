import java.sql.*;
import java.util.ArrayList;

public class DBHelper {
    private Connection conn;

    public DBHelper() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, course TEXT, marks INTEGER)");
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    public void insert(Student s) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getMarks());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    public ArrayList<Student> fetchAll() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("Fetch Error: " + e.getMessage());
        }
        return list;
    }

    public void update(int id, String name, String course, int marks) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, course=?, marks=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, marks);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            conn.createStatement().execute("DELETE FROM students WHERE id=" + id);
        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}
