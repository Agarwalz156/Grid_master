package assignment_package;

import java.text.SimpleDateFormat;
import java.util.Date;

public class assignment_test2 {
    public static void main(String[] args) {
        System.out.println("\n==============================================================\n");
        System.out.println("\n--- Library Management System Using (Abstraction) ---");
        Library libUser = new LibraryUser();
        libUser.libraryTiming();
        libUser.issueBook("Java Basics ", 101, "John Smith");
        libUser.returnBook("Java Basics ", 101);



        System.out.println("\n==============================================================\n");
        System.out.println("\n--- Encapsulation Example ---");
        Account_Encapsulation acc = new Account_Encapsulation();
        acc.setAccount("Rahul Sharma", 5000.75);
        acc.displayAccount();
        System.out.println("\n------------------------------------------\n");
        System.out.println("\n--- Abstraction Example ---\n");
        Account_abstraction acco = new BankUser();
        acco.BankTiming();
        acco.setAccount("Rahul Sharma", 5000.75);


        System.out.println("\n==============================================================\n");
        System.out.println("\n--- Hierarchical Inheritance (College Management) ---");
        ViceChancellor vc = new ViceChancellor();
        vc.showRole();
        vc.manageUniversity();
        System.out.println("\n------------------------------------------\n");
        Director dir = new Director();
        dir.showRole();
        dir.manageCollege();
        System.out.println("\n------------------------------------------\n");
        HOD hod = new HOD();
        hod.showRole();
        hod.manageDepartment();
        System.out.println("\n==============================================================\n");


        System.out.println("\n--- Constructor Types ---");
        System.out.println("Default Constructor:-");
        Student s1 = new Student();
        s1.showStudent();
        System.out.println("\n------------------------------------------\n");
        System.out.println("Parameterized Constructor:-");
        Student s2 = new Student("Anjali", 101);
        s2.showStudent();
        System.out.println("\n------------------------------------------\n");
        System.out.println("Copy Constructor:-");
        Student s3 = new Student(s2);
        s3.showStudent();
    }
}

abstract class Library {
    abstract void issueBook(String bookName, int bookId, String authorName);
    abstract void returnBook(String bookName, int bookId);

    void libraryTiming() {
        System.out.println("Library is open from 9AM to 5PM.");
    }
}

class LibraryUser extends Library {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    @Override
    void issueBook(String bookName, int bookId, String authorName) {
        String issuedTime = sdf.format(new Date());
        System.out.println("Book Issued:-");
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + authorName);
        System.out.println("Issued Time: " + issuedTime);
        System.out.println("----------------------------------");
    }

    @Override
    void returnBook(String bookName, int bookId) {
        String returnTime = sdf.format(new Date());
        System.out.println("Book Returned:-");
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Return Time: " + returnTime);
        System.out.println("----------------------------------");
    }
}
class Account_Encapsulation {
    private String accountHolder;
    private double balance;

    public void setAccount(String name, double amount) {
        accountHolder = name;
        balance = amount;
    }

    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + ", Balance: ₹" + balance);
    }
}

abstract class Account_abstraction {
    abstract void setAccount(String name, double amount);

    void BankTiming() {
        System.out.println("Bank is open from 9AM to 5PM.");
    }
}

class BankUser extends Account_abstraction {
    @Override
    void setAccount(String name, double amount) {
        System.out.println("User '" + name + "' Amount: ₹" + amount);
    }
}
class CollegeMember {
    void showRole() {
        System.out.println("I am a member of the college.");
    }
}

class ViceChancellor extends CollegeMember {
    void manageUniversity() {
        System.out.println("Vice Chancellor manages the university.");
    }
}

class Director extends CollegeMember {
    void manageCollege(){
        System.out.println("Director manages the college.");
    }
}

class HOD extends CollegeMember {
    void manageDepartment() {
        System.out.println("HOD manages the department.");
    }
}

class Student {
    String name;
    int roll;

    Student() {
        name = "Not Assigned";
        roll = 0;
    }
    Student(String n, int r) {
        name = n;
        roll = r;
    }
    Student(Student s) {
        name = s.name;
        roll = s.roll;
    }

    void showStudent() {
        System.out.println("Name: " + name + ", Roll: " + roll);
    }
}
