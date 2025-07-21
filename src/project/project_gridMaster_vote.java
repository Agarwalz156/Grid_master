package project;
import java.util.Scanner;


public class project_gridMaster_vote {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to GridMaster - Career Eligibility Analyzer");
            System.out.print("Enter number of candidates: ");
            int numCandidates = scanner.nextInt();
            scanner.nextLine(); // consume newline

            for (int i = 1; i <= numCandidates; i++) {
                System.out.println("\nCandidate " + i + ":");

                System.out.print("Enter candidate's name: ");
                String name = scanner.nextLine();

                System.out.print("Enter candidate's age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // consume newline

                String status;
                String recommendation;

                if (age < 18) {
                    status = "Minor";
                    recommendation = "Not eligible for jobs. Focus on schooling.";
                } else if (age >= 18 && age < 21) {
                    status = "Undergraduate";
                    recommendation = "Should complete degree before applying for most jobs.";
                } else if (age >= 21 && age < 24) {
                    status = "Graduate";
                    recommendation = "Ideal time for government job preparation or skill development.";
                } else if (age >= 24 && age <= 60) {
                    status = "Working Age";
                    recommendation = "Eligible for most government and private sector jobs.";
                } else {
                    status = "Senior Citizen";
                    recommendation = "Usually retired; eligible for pension and senior benefits.";
                }

                // Output
                System.out.println("------------------------------------------------");
                System.out.println("Name          : " + name);
                System.out.println("Age           : " + age);
                System.out.println("Status        : " + status);
                System.out.println("Recommendation: " + recommendation);
                System.out.println("------------------------------------------------");
            }

            System.out.println("\nThank you for using GridMaster Career Analyzer.");
            scanner.close();
        }
    }


