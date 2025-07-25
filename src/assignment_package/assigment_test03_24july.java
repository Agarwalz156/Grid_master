package assignment_package;
import java.util.*;
public class assigment_test03_24july {
    public static void main(String[] args) {

        System.out.println( "Create an ArrayList and find the second minimum element");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(5);
        numbers.add(15);
        numbers.add(null);

        System.out.println("Original ArrayList: " + numbers);
        ArrayList<Integer> nonNullNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (num != null) nonNullNumbers.add(num);
        }

        Collections.sort(nonNullNumbers);
        Integer secondMin = null;
        for (int i = 1; i < nonNullNumbers.size(); i++) {
            if (!nonNullNumbers.get(i).equals(nonNullNumbers.get(0))) {
                secondMin = nonNullNumbers.get(i);
                break;
            }
        }
        System.out.println("Second minimum element: " + secondMin);
        System.out.println();


        System.out.println("Collection Framework");
        System.out.println("Collection Framework provides ready-to-use data structures like List, Set, Map. \nArrayList is part of List Interface in Collection Framework.");

        System.out.println();
        System.out.println("Convert ArrayList to HashSet to find all unique elements");
        HashSet<Integer> uniqueSet = new HashSet<>(numbers);
        System.out.println("Unique elements (HashSet): " + uniqueSet);
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");

        fruits.add(null);

        System.out.println("Fruits list (ArrayList): " + fruits);
        Set<String> uniqueFruits = new HashSet<>(fruits);
        System.out.println("Unique fruits (HashSet): " + uniqueFruits);

        System.out.println();
        System.out.println("Display the in-bulit Method to Perform Spefic Task:-");
        ArrayList<String> list = new ArrayList<>();

        // Add
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add(null);

        System.out.println("\nCurrent list: " + list);

        // Delete
        list.remove("C++");
        list.remove(0);

        System.out.println("After delete: " + list);

        // Update
        list.set(0, "JavaScript");
        System.out.println("After update: " + list);

        // Check if contains
        System.out.println("Contains 'Python'? " + list.contains("Python"));
        System.out.println("Contains 'Java'? " + list.contains("Java"));

        // Check for null
        System.out.println("Contains null? " + list.contains(null));
    }

}
