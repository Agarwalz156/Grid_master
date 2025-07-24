
package project;

import java.text.SimpleDateFormat;
import java.util.*;

abstract class Library {
    abstract void issueBook(int bookId);
    abstract void returnBook(int bookId);

    void libraryTiming() {
        System.out.println("Library is open from 9AM to 5PM.");
    }
}

class Book {
    int bookId;
    String title;
    String author;
    int availableCopies;

    Book(int bookId, String title, String author, int availableCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

class IssueRecord {
    Book book;
    Date issueDate;
    Date dueDate;

    IssueRecord(Book book, Date issueDate, Date dueDate) {
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }
}

class Student {
    int studentId;
    String name;
    String course;
    int year;
    String password;
    List<IssueRecord> issuedBooks = new ArrayList<>();
    List<String> history = new ArrayList<>();

    Student(int studentId, String name, String course, int year, String password) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
        this.password = password;
    }
}

class LibraryUser extends Library {
    Map<Integer, Book> bookCatalog;
    Student student;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    LibraryUser(Map<Integer, Book> bookCatalog, Student student) {
        this.bookCatalog = bookCatalog;
        this.student = student;
    }

    @Override
    void issueBook(int bookId) {
        if (!bookCatalog.containsKey(bookId)) {
            System.out.println("Book not found.");
            return;
        }
        if (student.issuedBooks.size() >= 3) {
            System.out.println("You can issue a maximum of 3 books.");
            return;
        }

        Book book = bookCatalog.get(bookId);
        if (book.availableCopies <= 0) {
            System.out.println("Book not available.");
            return;
        }

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, 7);
        Date due = cal.getTime();

        IssueRecord record = new IssueRecord(book, now, due);
        student.issuedBooks.add(record);
        student.history.add("Issued: " + book.title + " on " + sdf.format(now));
        book.availableCopies--;
        System.out.println("Book issued successfully. Due date: " + sdf.format(due));
    }

    @Override
    void returnBook(int bookId) {
        IssueRecord toReturn = null;
        for (IssueRecord r : student.issuedBooks) {
            if (r.book.bookId == bookId) {
                toReturn = r;
                break;
            }
        }
        if (toReturn == null) {
            System.out.println("This book was not issued to you.");
            return;
        }

        Date now = new Date();
        long diff = now.getTime() - toReturn.dueDate.getTime();
        long daysLate = diff / (1000 * 60 * 60 * 24);
        if (daysLate > 0) {
            System.out.println("Book returned late. Fine: ₹" + (daysLate * 5));
        } else {
            System.out.println("Book returned on time. No fine.");
        }
        toReturn.book.availableCopies++;
        student.issuedBooks.remove(toReturn);
        student.history.add("Returned: " + toReturn.book.title + " on " + sdf.format(now));
    }
}

public class project_Libary_Management_System {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Book> bookCatalog = new HashMap<>();
    static Map<Integer, Student> studentDB = new HashMap<>();

    public static void main(String[] args) {
        seedBooks();
        boolean running = true;

        while (running) {
            System.out.println("\n📚 Welcome to SmartLibrary");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> loginStudent();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void seedBooks() {
        bookCatalog.put(101, new Book(101, "The Alchemist", "Paulo Coelho", 5));
        bookCatalog.put(102, new Book(102, "Clean Code", "Robert C. Martin", 3));
        bookCatalog.put(103, new Book(103, "Effective Java", "Joshua Bloch", 4));
    }

    static void registerStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Set password: ");
        String pass = sc.nextLine();

        studentDB.put(id, new Student(id, name, course, year, pass));
        System.out.println("Registration successful!");
    }

    static void loginStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (!studentDB.containsKey(id) || !studentDB.get(id).password.equals(pass)) {
            System.out.println("Invalid login.");
            return;
        }

        Student student = studentDB.get(id);
        LibraryUser user = new LibraryUser(bookCatalog, student);

        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nWelcome, " + student.name);
            System.out.println("1. View Book Catalog");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Issued Books");
            System.out.println("5. View History");
            System.out.println("6. View Profile");
            System.out.println("7. Library Timing");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            int c = sc.nextInt();

            switch (c) {
                case 1 -> {
                    System.out.println("\nBook Catalog:");
                    for (Book b : bookCatalog.values()) {
                        System.out.println(b.bookId + ": " + b.title + " by " + b.author + " [Available: " + b.availableCopies + "]");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int bid = sc.nextInt();
                    user.issueBook(bid);
                }
                case 3 -> {
                    System.out.print("Enter Book ID to return: ");
                    int bid = sc.nextInt();
                    user.returnBook(bid);
                }
                case 4 -> {
                    System.out.println("\nYour Issued Books:");
                    for (IssueRecord r : student.issuedBooks) {
                        System.out.println(r.book.title + " (Due: " + new SimpleDateFormat("dd-MM-yyyy").format(r.dueDate) + ")");
                    }
                }
                case 5 -> {
                    System.out.println("\nTransaction History:");
                    for (String entry : student.history) {
                        System.out.println(entry);
                    }
                }
                case 6 -> {
                    System.out.println("\nProfile:");
                    System.out.println("Name: " + student.name);
                    System.out.println("Course: " + student.course);
                    System.out.println("Year: " + student.year);
                }
                case 7 -> user.libraryTiming();
                case 0 -> loggedIn = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
