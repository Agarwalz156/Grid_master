public class java_forloop_task_ass4july {
        public static void main(String[] args) {

            // 1. Factorial of a given number
            System.out.println("1. Find the Factorial of a Given Number:");
            int number = 5;
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + number + " is: " + factorial);

            // 2. Table of 5
            System.out.println("\n2. Table of 5:");
            int tableNum = 5;
            for (int i = 1; i <= 10; i++) {
                System.out.println(tableNum + " x " + i + " = " + (tableNum * i));
            }

            // 3. Square of numbers from 2 to 10
            System.out.println("\n3. Squares of Numbers from 2 to 10:");
            for (int i = 2; i <= 10; i++) {
                System.out.println("Square of " + i + " = " + (i * i));
            }

            // 4. Sum of first 10 natural numbers
            System.out.println("\n4. Sum of First 10 Natural Numbers:");
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            System.out.println("Sum = " + sum);

            // 5. First 10 Even Numbers
            System.out.println("\n5. First 10 Even Numbers:");
            for (int i = 1, count = 0; count < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    count++;
                }
            }

            // 6. First 10 Odd Numbers
            System.out.println("\n6. First 10 Odd Numbers:");
            for (int i = 1, count = 0; count < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    count++;
                }
            }
        }

}
