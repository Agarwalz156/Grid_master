package project;
import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String gender;
    String disease;
    String admissionDate;

    Patient(int id, String name, int age, String gender, String disease, String admissionDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.admissionDate = admissionDate;
    }

    void display() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Disease: " + disease);
        System.out.println("Admission Date: " + admissionDate);
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

class Appointment {
    int appointmentId;
    int patientId;
    int doctorId;
    String dateTime;

    Appointment(int appointmentId, int patientId, int doctorId, String dateTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
    }

    void display() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date/Time: " + dateTime);
    }
}

class Bill {
    int billId;
    int patientId;
    double amount;
    String description;

    Bill(int billId, int patientId, double amount, String description) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.description = description;
    }

    void display() {
        System.out.println("Bill ID: " + billId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Description: " + description);
    }
}

public class project_Hospital_Management_System {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Patient> patients = new HashMap<>();
    static Map<Integer, Doctor> doctors = new HashMap<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Bill> bills = new ArrayList<>();
    static int patientIdCounter = 100;
    static int doctorIdCounter = 200;
    static int appointmentIdCounter = 300;
    static int billIdCounter = 400;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🏥 HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Generate Bill");
            System.out.println("8. View Bills");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> addDoctor();
                case 4 -> viewDoctors();
                case 5 -> bookAppointment();
                case 6 -> viewAppointments();
                case 7 -> generateBill();
                case 8 -> viewBills();
                case 0 -> {
                    System.out.println("Exiting system. Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter gender: ");
        String gender = sc.next();
        System.out.print("Enter disease: ");
        String disease = sc.next();
        System.out.print("Enter admission date (dd-mm-yyyy): ");
        String date = sc.next();

        Patient p = new Patient(patientIdCounter++, name, age, gender, disease, date);
        patients.put(p.id, p);
        System.out.println("Patient added with ID: " + p.id);
    }

    static void viewPatients() {
        if (patients.isEmpty()) System.out.println("No patients found.");
        else for (Patient p : patients.values()) {
            System.out.println("---------------------");
            p.display();
        }
    }

    static void addDoctor() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter specialization: ");
        String spec = sc.next();

        Doctor d = new Doctor(doctorIdCounter++, name, spec);
        doctors.put(d.id, d);
        System.out.println("Doctor added with ID: " + d.id);
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) System.out.println("No doctors found.");
        else for (Doctor d : doctors.values()) {
            System.out.println("---------------------");
            d.display();
        }
    }

    static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();
        System.out.print("Enter date/time (dd-mm-yyyy HH:mm): ");
        sc.nextLine();
        String datetime = sc.nextLine();

        if (patients.containsKey(pid) && doctors.containsKey(did)) {
            Appointment a = new Appointment(appointmentIdCounter++, pid, did, datetime);
            appointments.add(a);
            System.out.println("Appointment booked.");
        } else {
            System.out.println("Invalid Patient or Doctor ID.");
        }
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) System.out.println("No appointments found.");
        else for (Appointment a : appointments) {
            System.out.println("---------------------");
            a.display();
        }
    }

    static void generateBill() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        System.out.print("Enter description: ");
        sc.nextLine();
        String desc = sc.nextLine();

        Bill b = new Bill(billIdCounter++, pid, amt, desc);
        bills.add(b);
        System.out.println("Bill generated with ID: " + b.billId);
    }

    static void viewBills() {
        if (bills.isEmpty()) System.out.println("No bills found.");
        else for (Bill b : bills) {
            System.out.println("---------------------");
            b.display();
        }
    }
}
