package project;
import java.util.*;

import java.text.SimpleDateFormat;


class Transaction {
    private String type;
    private double amount;
    private String date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    }

    public String toString() {
        return date + " | " + type + " | ₹" + amount;
    }
}

// ======= ABSTRACT BANK ACCOUNT =======
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected ArrayList<Transaction> history;

    public BankAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.history = new ArrayList<>();
        history.add(new Transaction("Account Created", initialDeposit));
    }

    public void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            history.add(new Transaction("Withdrawal", amount));
        } else {
            System.out.println("❌ Insufficient Balance.");
        }
    }

    public void printStatement() {
        System.out.println("📄 Statement for Account: " + accountNumber);
        for (Transaction t : history) {
            System.out.println(t);
        }
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// ======= SAVINGS ACCOUNT =======
class SavingsAccount extends BankAccount {
    private final double interestRate = 3.5;
    private final double withdrawalPenalty = 10;

    public SavingsAccount(String accNum, double balance) {
        super(accNum, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= (amount + withdrawalPenalty)) {
            balance -= (amount + withdrawalPenalty);
            history.add(new Transaction("Withdraw with Penalty", amount + withdrawalPenalty));
        } else {
            System.out.println("❌ Not enough balance for withdrawal + penalty.");
        }
    }
}

// ======= CURRENT ACCOUNT =======
class CurrentAccount extends BankAccount {
    private final double overdraftLimit = 5000;

    public CurrentAccount(String accNum, double balance) {
        super(accNum, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            history.add(new Transaction("Withdraw (Overdraft)", amount));
        } else {
            System.out.println("❌ Overdraft limit exceeded.");
        }
    }
}

// ======= DEBIT CARD =======
class DebitCard {
    private String cardNumber;
    private String expiry;
    private int pin;
    private BankAccount linkedAccount;

    public DebitCard(BankAccount account) {
        this.linkedAccount = account;
        this.cardNumber = "4312" + (int)(Math.random() * 100000000);
        this.expiry = "12/30";
        this.pin = 1000 + new Random().nextInt(9000);
    }

    public void makePayment(int inputPin, double amount) {
        if (inputPin != pin) {
            System.out.println("❌ Incorrect PIN.");
            return;
        }
        if (linkedAccount.getBalance() >= amount) {
            linkedAccount.withdraw(amount);
            System.out.println("✅ Payment of ₹" + amount + " successful via Debit Card.");
        } else {
            System.out.println("❌ Insufficient funds.");
        }
    }

    public void displayCard() {
        System.out.println("💳 Card Number: " + cardNumber);
        System.out.println("📅 Expiry: " + expiry);
        System.out.println("🔐 PIN: " + pin + " (do not share!)");
    }
}

// ======= LOAN =======
class Loan {
    private static int loanCounter = 1;
    private int loanId;
    private double principal;
    private double interestRate;
    private double remainingAmount;
    private boolean approved;

    public Loan(double principal, double interestRate) {
        this.loanId = loanCounter++;
        this.principal = principal;
        this.interestRate = interestRate;
        this.remainingAmount = principal + (principal * interestRate / 100);
        this.approved = false;
    }

    public void approve() {
        approved = true;
        System.out.println("✅ Loan #" + loanId + " Approved. Total Due: ₹" + remainingAmount);
    }

    public void repay(double amount) {
        if (!approved) {
            System.out.println("❌ Loan not approved yet.");
            return;
        }
        if (remainingAmount <= 0) {
            System.out.println("✅ Loan already fully paid.");
            return;
        }
        remainingAmount -= amount;
        System.out.println("💰 Paid ₹" + amount + ". Remaining: ₹" + remainingAmount);
    }

    public String toString() {
        return "Loan#" + loanId + " | Due: ₹" + remainingAmount + " | Approved: " + approved;
    }
}

// ======= CUSTOMER =======
class Customer {
    private static int idCounter = 1001;
    private int customerId;
    private String name, username, password;
    private BankAccount account;
    private DebitCard debitCard;
    private Loan loan;

    public Customer(String name, String username, String password, String accountType, double initialDeposit) {
        this.customerId = idCounter++;
        this.name = name;
        this.username = username;
        this.password = password;

        String accNum = accountType.substring(0, 2).toUpperCase() + "202507" + customerId;

        if (accountType.equalsIgnoreCase("savings")) {
            this.account = new SavingsAccount(accNum, initialDeposit);
        } else {
            this.account = new CurrentAccount(accNum, initialDeposit);
        }
    }

    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void showBalance() {
        System.out.println("💰 Current Balance: ₹" + account.getBalance());
    }

    public void printStatement() {
        account.printStatement();
    }

    public void issueCard() {
        this.debitCard = new DebitCard(account);
        debitCard.displayCard();
    }

    public void payWithCard(int pin, double amount) {
        if (debitCard == null) {
            System.out.println("❌ No debit card issued.");
            return;
        }
        debitCard.makePayment(pin, amount);
    }

    public void applyLoan(double amount, double rate) {
        this.loan = new Loan(amount, rate);
        System.out.println("📄 Loan Application Submitted: " + loan);
    }

    public void approveLoan() {
        if (loan != null) loan.approve();
    }

    public void repayLoan(double amount) {
        if (loan != null) loan.repay(amount);
    }

    public void showDetails() {
        System.out.println("🧑 Customer ID: " + customerId);
        System.out.println("👤 Name: " + name);
        System.out.println("🏦 Account#: " + account.getAccountNumber());
    }
}

// ======= MAIN APP =======
public class project_SmartBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a customer for demo
        Customer customer = new Customer("Red Ranger", "Dino_ranger", "Dinocharger", "savings", 1000);

        // Login
        System.out.print("👤 Username: ");
        String user = sc.nextLine();
        System.out.print("🔐 Password: ");
        String pass = sc.nextLine();

        if (!customer.login(user, pass)) {
            System.out.println("❌ Login failed. Exiting.");
            return;
        }

        System.out.println("✅ Welcome " + user + "!");

        while (true) {
            System.out.println("\n📋 MENU:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Print Statement");
            System.out.println("5. Issue Debit Card");
            System.out.println("6. Pay with Card");
            System.out.println("7. Apply Loan");
            System.out.println("8. Approve Loan (Bank)");
            System.out.println("9. Repay Loan");
            System.out.println("10. Show Customer Info");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter deposit ₹: ");
                    customer.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdraw ₹: ");
                    customer.withdraw(sc.nextDouble());
                    break;
                case 3:
                    customer.showBalance();
                    break;
                case 4:
                    customer.printStatement();
                    break;
                case 5:
                    customer.issueCard();
                    break;
                case 6:
                    System.out.print("Enter PIN: ");
                    int pin = sc.nextInt();
                    System.out.print("Enter amount ₹: ");
                    customer.payWithCard(pin, sc.nextDouble());
                    break;
                case 7:
                    System.out.print("Loan amount ₹: ");
                    double amt = sc.nextDouble();
                    System.out.print("Interest rate %: ");
                    double rate = sc.nextDouble();
                    customer.applyLoan(amt, rate);
                    break;
                case 8:
                    customer.approveLoan();
                    break;
                case 9:
                    System.out.print("Repay ₹: ");
                    customer.repayLoan(sc.nextDouble());
                    break;
                case 10:
                    customer.showDetails();
                    break;
                case 0:
                    System.out.println("👋 Thanks for using SmartBank.");
                    return;
                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}
