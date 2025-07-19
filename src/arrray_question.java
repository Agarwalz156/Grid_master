import java.util.Arrays;
import java.util.*;
public class arrray_question {
        public static void main(String[] args) {

            int[] numbers = {10, 20, 30, 40, 50}; // Sample array
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }

            double average = (double) sum / numbers.length;
            System.out.println("Finding the Average and Sum of the Give array:-");
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);


            System.out.println("Printing the second largest number using using sort Method");
            int[] arr = {12, 45, 7, 34, 89, 45, 89}; // Sample array

            Arrays.sort(arr);

            int secondLargest = -1;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] < arr[arr.length - 1]) {
                    secondLargest = arr[i];
                    break;
                }
            }

            System.out.println(
                    (secondLargest == -1) ?
                            "No second largest element found." :
                            "Second Largest Element: " + secondLargest
            );

            System.out.println("Printing the Second Largest NUmber without Using in-bulit function");

            if (arr.length < 2) {
                System.out.println("Array must contain at least two elements.");
                return;
            }

            int larg = Integer.MIN_VALUE;
            int secondLarg = Integer.MIN_VALUE;

            for (int num : arr) {
                if (num > larg) {
                    secondLarg = larg;
                    larg = num;
                } else if (num > secondLarg && num != larg) {
                    secondLarg = num;
                }
            }

            if (secondLarg == Integer.MIN_VALUE) {
                System.out.println("No second largest element found (all elements may be equal).");
            } else {
                System.out.println("Second Largest Element: " + secondLarg);
            }


            int[] arr2 = {1, 2, 3, 2, 4, 1, 5};

            Set<Integer> set = new LinkedHashSet<>();
            for (int num : arr2) {
                set.add(num);
            }

            System.out.println("Array without duplicates:");
            for (int num : set) {
                System.out.print(num + "  ");
            }

            int[] arr1 = {1, 2, 3, 4, 5};
            int k = 2; // Rotate right by 2

            for (int i =0; i < k; i++) {
                int last = arr1[arr1.length - 1];
                for (int j = arr1.length - 1; j > 0; j--) {
                    arr1[j] = arr1[j - 1];
                }
                arr1[0] = last;
            }
            System.out.println();
            System.out.println("Rotated Array: " + Arrays.toString(arr1));

        }
}
