public class java_interface {
    public static void main(String[] args) {
        System.out.println("Inheritance:-");
        Shape circle = new Circle(7);
        Shape rectangle = new Rectangle(5, 3);
        Shape triangle = new Triangle(4, 5, 6, 3);

        circle.displayParameters();
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + ((Perimeter) circle).perimeter());
        System.out.println();

        rectangle.displayParameters();
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + ((Perimeter) rectangle).perimeter());
        System.out.println();

        triangle.displayParameters();
        System.out.println("Area: " + triangle.area());
        System.out.println("Perimeter: " + ((Perimeter) triangle).perimeter());
        System.out.println();

        System.out.println("Method Overloading:-");
        ShapeCalculator calculator = new ShapeCalculator();

        System.out.println("Area of Circle (r=7): " + calculator.area(7.0));
        System.out.println("Area of Rectangle (5 x 3): " + calculator.area(5.0, 3.0));
        System.out.println("Area of Triangle (base=4, height=6): " + calculator.area(4.0, 6.0, true));
        System.out.println("Area of Square (side=4): " + calculator.area(4));
    }
}

interface Shape {
    double area();
    void displayParameters();
}

interface Perimeter {
    double perimeter();
}

class Rectangle implements Shape, Perimeter {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public void displayParameters() {
        System.out.println("Shape: Rectangle");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }
}

class Circle implements Shape, Perimeter {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public void displayParameters() {
        System.out.println("Shape: Circle");
        System.out.println("Radius: " + radius);
    }
}

class Triangle implements Shape, Perimeter {
    private double sideA, sideB, sideC;
    private double height;

    public Triangle(double sideA, double sideB, double sideC, double height) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
    }

    public double area() {
        return 0.5 * sideA * height;
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public void displayParameters() {
        System.out.println("Shape: Triangle");
        System.out.println("Sides: " + sideA + ", " + sideB + ", " + sideC);
        System.out.println("Height: " + height);
    }
}

class ShapeCalculator {
    public double area(double radius) {
        return Math.PI * radius * radius;
    }
    public double area(double length, double width) {
        return length * width;
    }
    public double area(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }
    public int area(int side){
        return side * side;
    }
}
