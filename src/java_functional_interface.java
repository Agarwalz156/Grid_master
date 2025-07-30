import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class java_functional_interface {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Running without a thread.");
        runnable.run();

        Callable<String> callable = () -> "Called without thread.";
        try {
            String result = callable.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 8 even? " + isEven.test(8));

        Predicate<String> isPalindrome = str -> {
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed);
        };

        Predicate<Integer> isPalindromen = number -> {
            String original = number.toString();
            String reversed = new StringBuilder(original).reverse().toString();
            return original.equals(reversed);
        };

        int input1 = 123;
        String input2 = "hello";

        System.out.println("Is '" + input1 + "' a palindrome? " + isPalindromen.test(input1));
        System.out.println("Is '" + input2 + "' a palindrome? " + isPalindrome.test(input2));
    }
}
