import java.util.*;
public class java_iterator {


        public static void main(String[] args) {
            // Create a list of integers
            List<Integer> numbers = new ArrayList<>();

            // Add elements to the list
            numbers.add(10);
            numbers.add(20);
            numbers.add(30);
            numbers.add(40);
            numbers.add(50);

            // Print the list
            System.out.println("Integer List: " + numbers);

            // Access individual elements
            System.out.println("First element: " + numbers.get(0));
            System.out.println("Size of list: " + numbers.size());

            // Iterate over the list
            System.out.println("Iterating over list:");
            for (int num : numbers) {
                System.out.println(num);
            }
        }
    }

  //  how to use arraylist to implement to stack;
//remove duplicate from colllection using the set;
// hashmap to store null value or not