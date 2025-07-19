public class java_abstraction {
    public static void main(String[] args) {
        Vehicle cars = new cars();
        cars.start();
        cars.fuelType();

        Vehicle bike = new Bike();
        bike.start();
        bike.fuelType();

        System.out.println("\n======================================================\n");
        RBI bank1 = new SBI();
        RBI bank2 = new HDFC();
        RBI bank3 = new ICICI();

        System.out.println("=== SBI ===");
        bank1.rbiGuidelines();
        System.out.println("Interest Rate: " + bank1.getInterestRate() + "%");
        System.out.println(bank1.getHomeLoanDetails());

        System.out.println("\n=== HDFC ===");
        bank2.rbiGuidelines();
        System.out.println("Interest Rate: " + bank2.getInterestRate() + "%");
        System.out.println(bank2.getHomeLoanDetails());

        System.out.println("\n=== ICICI ===");
        bank3.rbiGuidelines();
        System.out.println("Interest Rate: " + bank3.getInterestRate() + "%");
        System.out.println(bank3.getHomeLoanDetails());
        System.out.println("\n=======================================================\n");
    }
}

abstract class Vehicle {
    abstract void start();

    void fuelType() {
        System.out.println("Most vehicles use petrol or diesel.");
    }
}

class cars extends Vehicle {
    void start() {
        System.out.println("Car starts with key ignition.");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with kick or self-start.");
    }
}
abstract class RBI {

    abstract double getInterestRate();
    abstract String  getHomeLoanDetails();

    void rbiGuidelines() {
        System.out.println("Follow RBI Guidelines for all loan and interest calculations.");
    }
}
class SBI extends RBI {
    @Override
    double getInterestRate() {
        return 7.0;
    }
    @Override
    String getHomeLoanDetails() {
        return "SBI Home Loan: Min ₹2L to ₹30L, tenure up to 30 years.";
    }
}

class HDFC extends RBI {
    @Override
    double getInterestRate() {
        return 8.2;
    }

    @Override
    String getHomeLoanDetails() {
        return "HDFC Home Loan: Min ₹5L to ₹75L, tenure up to 25 years.";
    }
}

class ICICI extends RBI {
    @Override
    double getInterestRate() {
        return 7.5;
    }

    @Override
    String getHomeLoanDetails() {
        return "ICICI Home Loan: Min ₹3L to ₹50L, tenure up to 20 years.";
    }
}