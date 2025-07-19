import java.util.Arrays;

public class assigment_test {

    public static int sumEven(int n) {
        if (n == 0) return 0;
        return (2 * n) + sumEven(n - 1);
    }

    public static void main(String[] args) {

        System.out.println(" Check that element exists in the array or not:-");
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        boolean found = false;

        for (int num : arr) {
            if (num == target) {
                found = true;
                break;
            }
        }

        System.out.println("Element " + target + (found ? " is present." : " is not present."));

        System.out.println();
        System.out.println("Use binary search to find index of 3 in a Given Array array:-");
        int[] arr2 = {43, 44, 47, 52, 91, 60, 2};
        Arrays.sort(arr2);
        

        int index = Arrays.binarySearch(arr2, 3);
        System.out.println("Sorted array: " + Arrays.toString(arr2));
        if (index >= 0)
            System.out.println("Index of 3: " + index);
        else
            System.out.println("3 not found in array.");

        System.out.println();
        System.out.println("Sum of first 5 even numbers using recursion:-");
        int result = sumEven(5);
        System.out.println("Sum of first 5 even numbers: " + result);

        System.out.println();
        System.out.println("Print table of 7:-");
        int number = 7;
        System.out.println("Table of 7:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));

        }
        System.out.println();
        System.out.println("Main Difference b/w StringBuffer and StringBulider");
        System.out.println("1.Thread Safety: \n StringBuffer is thread-safe suitable for multi-threaded than Stringbuffer \n2.Performance:\nStringBuffer is slower than StringBuilder ");
    }
}
