import java.util.ArrayList;

public class java_except_handling {
        public static void main(String[] args) {
            divide(10, 2);
            divide(10, 0);

            try {

                int a = 10;
                int b = 7;
                int result = a / b; // This will throw ArithmeticException

                int[] arr = {1, 2, 3};
                System.out.println(arr[5]); // This will throw ArrayIndexOutOfBoundsException

            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException caught: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("General Exception caught: " + e.getMessage());
            } finally {
                System.out.println("Finally block is always executed.");
            }

            System.out.println(" Custom Exception with throw");
            try {
                validateAge(15);
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }

        static void validateAge(int age) throws Exception {
            System.out.println(" Method that throws an exception");
            if (age < 18) {
                throw new Exception("Age must be 18 or above to vote.");
            } else {
                System.out.println("Eligible to vote.");
            }
        }

    static void divide(int numerator, int denominator) {
        try {
            int result = numerator / denominator;  // Risky line
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

}