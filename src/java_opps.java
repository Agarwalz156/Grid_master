public class java_opps {
    public static void main(String[] args) {

        Numbers obj = new Numbers();
        obj.setA(4000);
        obj.setB(6000);

        obj.sum();
        obj.sub();

        consttu obj2 = new consttu();
        obj2.setString("Power Ranger", 23);
        System.out.println(obj2);

        System.out.println("\n--------------------------");

        System.out.println("Using Non-parameterized constructor");
        Car car1 = new Car();
        car1.displayFull();

        System.out.println("Using parameterized constructor");
        Car car2 = new Car("Toyota Fortuner", "2024", 180, 34.5);
        car2.displayFull();

        System.out.println("Using partially parameterized constructor");
        Car car3 = new Car("2024", 180);
        car3.displayFull();

        System.out.println("\n==========================");
        System.out.println("     COPY CONSTRUCTOR ");
        System.out.println("==========================");


        Engine e1 = new Engine(200);
        Car original = new Car("Toyota", e1);

        System.out.println(" Shallow Copy");
        Car shallowCopy = new Car(original);

        System.out.println("Deep Copy");
        Car deepCopy = Car.deepCopy(original);


        System.out.println("--- Shallow Copy ---");
        shallowCopy.display();

        System.out.println("--- Deep Copy ---");
        deepCopy.display();

        original.engine.horsepower = 300;
        System.out.println("\n--------------------------");

        System.out.println("\nAfter modifying original car's engine horsepower to 300:");

        System.out.println("--- Original ---");
        original.display();

        System.out.println("--- Shallow Copy ---");
        shallowCopy.display();
        System.out.println("--- Deep Copy ---");
        deepCopy.display();
        System.out.println("\n--------------------------");

    }
}

class Numbers {
    private int a, b;

    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }

    public void sum() {
        System.out.println("Sum: " + (a + b));
    }

    public void sub() {
        System.out.println("Subtraction: " + (a - b));
    }
}

class consttu {
    private String name;
    private int age;

    public void setString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Engine {
    int horsepower;

    public Engine(int horsepower) {
        this.horsepower = horsepower;
    }
}

class Car {
    String name;
    String model;
    int speed;
    double average;
    Engine engine;

    // Non-Parameterized Constructor
    public Car() {
        this.name = "Safari";
        this.model = "2020";
        this.speed = 200;
        this.average = 50.0;
    }

    // Fully Parameterized Constructor
    public Car(String name, String model, int speed, double average) {
        this.name = name;
        this.model = model;
        this.speed = speed;
        this.average = average;
    }

    // Partial Constructor
    public Car(String model, int speed) {
        this.name = "Default";
        this.model = model;
        this.speed = speed;
        this.average = 0.0;
    }

    // Parameterized Constructor with Engine
    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }


    public Car(Car other) {
        this.name = other.name;
        this.engine = other.engine; // shallow copy
    }

    public static Car deepCopy(Car other) {
        Engine newEngine = new Engine(other.engine.horsepower);
        return new Car(other.name, newEngine);
    }

    public void display() {
        System.out.println("Car: " + name + ", Engine HP: " + engine.horsepower);
    }

    public void displayFull() {
        System.out.println("Car Name   : " + name);
        System.out.println("Car Model  : " + model);
        System.out.println("Top Speed  : " + speed + " km/h");
        System.out.println("Mileage    : " + average + " km/l");
        System.out.println("--------------------------");
    }
}
