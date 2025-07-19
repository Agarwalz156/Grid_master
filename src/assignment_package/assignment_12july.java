package assignment_package;

public class assignment_12july {
    static boolean isPowerOfTwo(int n) {

        if (n == 1)
            return true;
        if (n < 1 || n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }
    static int regularFactorial(int n) {
        if (n == 0)
            return 1;

        return n * regularFactorial(n - 1);
    }
    static int tailFactorialHelper(int n, int result) {
        if (n == 0)
            return result;
        return tailFactorialHelper(n - 1, n * result);
    }
    static int tailFactorial(int n) {
        return tailFactorialHelper(n, 1);
    }

    public static void main(String[] args) {
        int number = 5;

        int regularResult = regularFactorial(number);
        int tailResult = tailFactorial(number);

        System.out.println("Factorial using regular recursion of " + number + " is: " + regularResult);
        System.out.println("Factorial using tail recursion of " + number + " is: " + tailResult);

        int numbern = 6;

        if (isPowerOfTwo(numbern))
            System.out.println(numbern + " is a power of 2");
        else
            System.out.println(numbern + " is NOT a power of 2");
    }
}
