import java.sql.*;

public class java_jdbc {

    // JDBC credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Jaishreeram";

    // Connect to database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("✅ Connected to MySQL");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("❌ Connection failed:");
            e.printStackTrace();
        }
        return connection;
    }

    // 🔹 CREATE - Insert user using PreparedStatement
    public static void createUser(String name, String email, int age) {
        String sql = "INSERT INTO Users (name, email, age) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString (1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);

            int rows = stmt.executeUpdate();
            System.out.println("✅ INSERTED: " + rows + " row(s)");
        } catch (SQLException e) {
            System.err.println("❌ Insert failed:");
            e.printStackTrace();
        }
    }

    // 🔹 READ - Fetch all users (no parameters)
    public static void readUsers() {
        String sql = "SELECT * FROM Users";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            System.out.println("🧾 Users:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Email: " + rs.getString("email")
                        + ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Read failed:");
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE - Update email by ID using PreparedStatement
    public static void updateUserEmail(int id, String newEmail) {
        String sql = "UPDATE Users SET email = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
            System.out.println("✅ UPDATED: " + rows + " row(s)");
        } catch (SQLException e) {
            System.err.println("❌ Update failed:");
            e.printStackTrace();
        }
    }

    // 🔹 DELETE - Delete user by ID using PreparedStatement
    public static void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println("🗑️ DELETED: " + rows + " row(s)");
        } catch (SQLException e) {
            System.err.println("❌ Delete failed:");
            e.printStackTrace();
        }
    }

    // 🔹 MAIN method to test all
    public static void main(String[] args) {
        // CREATE users
        createUser("Ay", "ice@example.com", 22);
        createUser("ni", "bgu@example.com", 25);

        // READ users
        readUsers();

        // UPDATE user
        updateUserEmail(1, "alice_new@example.com");

        // DELETE user
        deleteUser(7);


        // READ again
        readUsers();
    }
}
