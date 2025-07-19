// File: assignment_package/assigment_14july.java
package assignment_package;

public class assigment_14july {

    // Public method
    public void showAsciiSum(char ch1, char ch2) {
        int ascii1 = (int) ch1;
        int ascii2 = (int) ch2;
        int sum = ascii1 + ascii2;

        System.out.println("ASCII value of '" + ch1 + "' is: " + ascii1);
        System.out.println("ASCII value of '" + ch2 + "' is: " + ascii2);
        System.out.println("Sum of ASCII values: " + sum);
    }

    // Protected method
    protected void fibonacci(int n) {
        int first = 0, second = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    // Default access (no modifier) method
    void greet() {
        System.out.println("Hello! This is the default access method greet().");
    }

    // Private method
    private void internalMethod() {
        System.out.println("This is a private method.");
    }

    // Public method to access private method
    public void callPrivateMethod() {
        internalMethod();
    }
}
