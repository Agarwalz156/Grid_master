package project;

import java.util.Scanner;

public class project_gridMaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to GridMaster!");
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numStudents; i++) {
            System.out.println("\nStudent " + i + ":");

            System.out.print("Enter the name of the student: ");
            String name = sc.nextLine();

            System.out.print("Enter the marks of " + name + " (out of 100): ");
            int marks = sc.nextInt();
            sc.nextLine();

            String grade = "";
            String category = "";

            if (marks >= 90 && marks <= 100) {
                category = "Student has Performed well";
                grade = "A+";
            } else if (marks >= 80 && marks < 90) {
                category = "Good Performance";
                grade = "A";
            } else if (marks >= 70 && marks < 80) {
                category = "Need Imporvement";
                grade = "B";
            } else if (marks >= 60 && marks < 70) {
                category = "Average";
                grade = "C";
            } else if (marks >= 33 && marks < 60) {
                category = "Pass";
                grade = "D";
            } else if (marks >= 0 && marks < 33) {
                category = "Fail";
                grade = "F";
            } else {
                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                continue;
            }

            System.out.println("Student Name: " + name);
            System.out.println("Marks: " + marks);
            System.out.println("Category: " + category);
            System.out.println("Grade: " + grade);
        }

        sc.close();
    }
}
