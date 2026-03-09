import java.sql.*;
import java.util.Scanner;

public class MainSQL {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database!");

            String choice;
            do {
                menu();
                System.out.println("Enter choice:");
                choice = scan.nextLine();

                switch (choice) {
                    case "1": addStudent(conn, scan); break;
                    case "2": viewStudent(conn, scan); break;
                    case "3": removeStudent(conn, scan); break;
                    case "4": showAllStudents(conn); break;
                    case "5": updateStudent(conn, scan); break;
                }
            } while (!choice.equals("6"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void menu() {
        System.out.println("1. Add Students");
        System.out.println("2. View student grade");
        System.out.println("3. Remove Student");
        System.out.println("4. Show all Students");
        System.out.println("5. Update Student");
        System.out.println("6. Exit");
    }

    public static void addStudent(Connection conn, Scanner scan) throws SQLException {
        System.out.println("Enter name:");
        String name = scan.nextLine();
        System.out.println("Enter grades:");
        int grades = scan.nextInt();
        System.out.println("Enter age:");
        int age = scan.nextInt();
        scan.nextLine();

        String sql = "INSERT INTO students (name, age, grades) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setInt(3, grades);
            stmt.executeUpdate();
            System.out.println("Student added!");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Student already exists!");
        }
    }

    public static void viewStudent(Connection conn, Scanner scan) throws SQLException {
        System.out.println("Enter student name:");
        String name = scan.nextLine();
        String sql = "SELECT * FROM students WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") + ", Grades: " + rs.getInt("grades"));
            } else {
                System.out.println("Student not found!");
            }
        }
    }

    public static void showAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") + ", Grades: " + rs.getInt("grades"));
            }
        }
    }

    public static void removeStudent(Connection conn, Scanner scan) throws SQLException {
        System.out.println("Enter student name to remove:");
        String name = scan.nextLine();
        String sql = "DELETE FROM students WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student removed!");
            else System.out.println("Student not found!");
        }
    }

    public static void updateStudent(Connection conn, Scanner scan) throws SQLException {
        System.out.println("Enter student name to update:");
        String name = scan.nextLine();
        System.out.println("Enter new grades:");
        int grades = scan.nextInt();
        System.out.println("Enter new age:");
        int age = scan.nextInt();
        scan.nextLine();

        String sql = "UPDATE students SET grades = ?, age = ? WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, grades);
            stmt.setInt(2, age);
            stmt.setString(3, name);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated!");
            else System.out.println("Student not found!");
        }
    }
}