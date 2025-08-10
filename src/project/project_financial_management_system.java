package project;
import java.util.*;
import java.sql.*;
import java.util.Date;

class Transaction_boss {
    private int transactionId;
    private int accountId;
    private Date transactionDate;
    private double amount;

    // Constructor for new transaction
    public Transaction_boss(int accountId, Date transactionDate, double amount) {
        this.accountId = accountId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    // Constructor for existing transaction with ID
    public Transaction_boss(int transactionId, int accountId, Date transactionDate, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public int getTransactionId() { return transactionId; }
    public int getAccountId() { return accountId; }
    public Date getTransactionDate() { return transactionDate; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "Transaction{" +
                "ID=" + transactionId +
                ", accountId=" + accountId +
                ", date=" + transactionDate +
                ", amount=" + amount +
                '}';
    }
}

public class project_financial_management_system {

    private Connection conn;
    private Scanner sc = new Scanner(System.in);

    public project_financial_management_system() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl = "jdbc:mysql://localhost:3306/financial_db";
            String username = "root";
            String password = "Jaishreeram";
            conn = DriverManager.getConnection(dburl, username, password);
            conn.setAutoCommit(false);
            System.out.println("✅ Connected to MySQL database.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("❌ Error: " + e.getMessage());
            System.exit(1);
        }
    }

    // CREATE
    public void addTransaction() {
        try {
            System.out.print("Enter Account ID: ");
            int accId = sc.nextInt();
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();

            String sql = "INSERT INTO transactions (account_id, transaction_date, amount) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, accId);
                pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
                pstmt.setDouble(3, amt);
                pstmt.executeUpdate();
                conn.commit();
                System.out.println("✅ Transaction Added Successfully!");
            }
        } catch (SQLException e) {
            rollback();
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // READ
    public void viewTransactions() {
        try {
            System.out.print("Enter Account ID to View Transactions: ");
            int accId = sc.nextInt();
            String sql = "SELECT * FROM transactions WHERE account_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, accId);
                ResultSet rs = pstmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println(
                            "ID: " + rs.getInt("transaction_id") +
                                    " | Date: " + rs.getDate("transaction_date") +
                                    " | Amount: " + rs.getDouble("amount")
                    );
                }
                if (!found) System.out.println("⚠ No Transactions Found!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // UPDATE
    public void updateTransaction() {
        try {
            System.out.print("Enter Transaction ID to Update: ");
            int txnId = sc.nextInt();
            System.out.print("Enter New Amount: ");
            double amt = sc.nextDouble();

            String sql = "UPDATE transactions SET amount = ? WHERE transaction_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, amt);
                pstmt.setInt(2, txnId);
                int rows = pstmt.executeUpdate();
                conn.commit();
                if (rows > 0) {
                    System.out.println("✅ Transaction Updated Successfully!");
                } else {
                    System.out.println("⚠ Transaction Not Found!");
                }
            }
        } catch (SQLException e) {
            rollback();
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteTransaction() {
        try {
            System.out.print("Enter Transaction ID to Delete: ");
            int txnId = sc.nextInt();
            String sql = "DELETE FROM transactions WHERE transaction_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, txnId);
                int rows = pstmt.executeUpdate();
                conn.commit();
                if (rows > 0) {
                    System.out.println("✅ Transaction Deleted Successfully!");
                } else {
                    System.out.println("⚠ Transaction Not Found!");
                }
            }
        } catch (SQLException e) {
            rollback();
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void rollback() {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            System.out.println("⚠ Rollback Failed: " + ex.getMessage());
        }
    }

    // MENU
    public void menu() {
        while (true) {
            System.out.println("\n==== Financial Management Menu ====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> viewTransactions();
                case 3 -> updateTransaction();
                case 4 -> deleteTransaction();
                case 5 -> {
                    System.out.println("👋 Exiting...");
                    closeConnection();
                    return;
                }
                default -> System.out.println("⚠ Invalid Choice!");
            }
        }
    }

    private void closeConnection() {
        try {
            if (conn != null) conn.close();
            System.out.println("✅ Connection Closed.");
        } catch (SQLException e) {
            System.out.println("⚠ Error Closing Connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        project_financial_management_system fms = new project_financial_management_system();
        fms.menu();
    }
}
