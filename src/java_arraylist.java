import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Collections;

public class java_arraylist {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 20,4, 8, 15));
        ArrayList<Integer> subList = new ArrayList<>(Arrays.asList(5, 1, 10));
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println();
        System.out.println("Displaying the ArrayList");
        System.out.println("Fruits List: " + fruits);

        System.out.println();
        System.out.println("Accessing an element by index");
        System.out.println("First fruit: " + fruits.get(0));

        System.out.println();
        System.out.println("Updating an element");
        fruits.set(1, "Blueberry");
        System.out.println("Updated List: " + fruits);

        System.out.println();
        System.out.println("Removing an element");
        fruits.remove("Mango");
        System.out.println("After removing Mango: " + fruits);

        System.out.println();
        System.out.println("Looping through ArrayList:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println();
        System.out.println("Checking size");
        System.out.println("Total fruits: " + fruits.size());

        System.out.println();

        System.out.println("Clearing the list");
        fruits.clear();
        System.out.println("After clearing: " + fruits);

        System.out.println("\n===================================\n");
        System.out.println();
        System.out.println("Add (sum) two ArrayLists and store in a third");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();


        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);


        for (int i = 0; i < list1.size(); i++) {
            sumList.add(list1.get(i) + list2.get(i));
        }

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Sum List: " + sumList);

        System.out.println();
        System.out.println("Find the maximum element using for loop");
        int max = findMax(sumList);
        System.out.println("Maximum element in sumList: " + max);

        System.out.println();
        ArrayList<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(10);
        listWithDuplicates.add(20);
        listWithDuplicates.add(30);
        listWithDuplicates.add(10);
        listWithDuplicates.add(20);
        listWithDuplicates.add(50);

        System.out.println("List with duplicates: " + listWithDuplicates);
        System.out.print("Duplicate elements: ");
        printDuplicates(listWithDuplicates);


        System.out.println("\n===================================\n");
        System.out.println();
        System.out.println("Remove an element");
        fruits.remove("Apple");

        System.out.println();
        System.out.println("Check if Orange exists");
        if (fruits.contains("Orange")) {
            System.out.println("Orange exists.");
        }
        System.out.println();
        System.out.println("Find size");
        System.out.println("Size: " + fruits.size());

        System.out.println();
        System.out.println("Sort the list");
        Collections.sort(sumList);
        System.out.println("Sorted List: " + sumList);
        Collections.shuffle(sumList);
        System.out.println(sumList);

        System.out.println("\n===================================\n");
        System.out.println();
        System.out.println("Find second largest element");
        int secondLargest = findSecondLargest(list);
        System.out.println("Second Largest Element: " + secondLargest);

        System.out.println();
        System.out.println("Reverse the ArrayList");
        ArrayList<Integer> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        System.out.println("Reversed ArrayList: " + reversedList);

        System.out.println();
        System.out.println("Sort in descending order");
        ArrayList<Integer> descendingList = new ArrayList<>(list);
        descendingList.sort(Collections.reverseOrder());
        System.out.println("Sorted in Descending Order: " + descendingList);


        System.out.println();
        System.out.println("Travse the Arraylist");
        for (int num : list) {
            System.out.println(num);
        }

        System.out.println();
        System.out.println("Check Arraylist is the subset of arraylist or not" );
        boolean isSubset = list.containsAll(subList);
        if (isSubset) {
            System.out.println("subList is a subset of mainList.");
        } else {
            System.out.println("subList is NOT a subset of mainList.");
        }

        System.out.println();
        System.out.println("Find Intersection point in arraylist");
        ArrayList<Integer> intersection = new ArrayList<>(list);
        intersection.retainAll(list2);
        System.out.println("Intersection of list and list2: " + intersection);

        System.out.println();
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(10, 5, 20, 5, 8, 5, 15));
        System.out.println("Remove all the occurence of specfic element fromm Arraylist");
        int elementToRemove = 5;
        list4.removeIf(num -> num == elementToRemove);
        System.out.println("After removing all occurrences of " + elementToRemove + ": " + list4);

    }

    // Method to find max using for loop
    public static int findMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    // Method to find and print duplicates
    public static void printDuplicates(ArrayList<Integer> list) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            for (int dup : duplicates) {
                System.out.print(dup + " ");
            }
            System.out.println();
        }
    }
    public static int findSecondLargest(ArrayList<Integer> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("List must have at least two elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new RuntimeException("No second largest element found (all elements may be equal)");
        }

        return secondLargest;
    }
}
