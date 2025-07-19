
package assignment_package;
import java.util.*;
public class java_assigment_10july {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Reverse the string");
            System.out.print("Enter a string to reverse: ");
            String input1 = sc.nextLine();
            String reversed = new StringBuilder(input1).reverse().toString();
            System.out.println("Reversed: " + reversed);

            System.out.println("Split the string");
            System.out.print("\nEnter a sentence to split: ");
            String input2 = sc.nextLine();
            String[] words = input2.split(" ");
            System.out.println("Split words:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("Compare two strings");
            System.out.print("\nEnter first string to compare: ");
            String str1 = sc.nextLine();
            System.out.print("Enter second string to compare: ");
            String str2 = sc.nextLine();
            if (str1.equals(str2)) {
                System.out.println("Strings are equal.");
            } else {
                System.out.println("Strings are not equal.");
            }

            System.out.println("String Tokenizer");
            System.out.print("\nEnter a sentence for StringTokenizer: ");
            String input3 = sc.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(input3);
            System.out.println("Tokens:");
            while (tokenizer.hasMoreTokens()) {
                System.out.println(tokenizer.nextToken());
            }

            System.out.println(" Palindrome check");
            System.out.print("\nEnter a string to check palindrome: ");
            String input4 = sc.nextLine();
            String reversed4 = new StringBuilder(input4).reverse().toString();
            if (input4.equals(reversed4)) {
                System.out.println("It is a palindrome.");
            } else {
                System.out.println("It is not a palindrome.");
            }

            System.out.println("Convert string to integer using `atoi` equivalent (`Integer.parseInt`)");
            System.out.print("\nEnter a number string to convert to integer: ");
            String numberStr = sc.nextLine();
            try {
                int number = Integer.parseInt(numberStr); // atoi equivalent
                System.out.println("Converted number: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }

            sc.close();
        }
    }


