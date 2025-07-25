package assignment_package;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class assignment_24july_dsa {

    // Stack implementation using ArrayList
    static class Stack<T> {
        private ArrayList<T> list = new ArrayList<>();

        // Push element onto stack
        public void push(T item) {
            list.add(item);
        }

        // Pop element from stack
        public T pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return null;
            }
            return list.remove(list.size() - 1);
        }

        // Peek top element
        public T peek() {
            if (isEmpty()) return null;
            return list.get(list.size() - 1);
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // Get stack elements
        public ArrayList<T> getElements() {
            return list;
        }

        // Display stack
        public void printStack() {
            System.out.println("Stack (top to bottom):");
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
        }
    }

    // Method to remove duplicates using Set
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        Set<T> set = new HashSet<>(list);  // Removes duplicates automatically
        return new ArrayList<>(set);
    }

    // Main method
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push elements onto the stack (with duplicates)
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Apple");
        stack.push("Orange");
        stack.push("Banana");

        System.out.println("Original Stack:");
        stack.printStack();

        // Remove duplicates
        ArrayList<String> uniqueItems = removeDuplicates(stack.getElements());

        System.out.println("\nStack after removing duplicates:");
        for (int i = uniqueItems.size() - 1; i >= 0; i--) {
            System.out.println(uniqueItems.get(i));
        }


        System.out.println();
        System.out.println("Pattern Printing:-");
        char ch = 'A';
           for (int i = 7; i >= 1; i--) {
               for (int j = 0; j < i; j++) {
                   if (ch <= 'Z') {
                       System.out.print(ch);
                       ch++;
                   }
               }
               System.out.println();
           }
        int n = 5;

        // Upward Direction - Left aligned *
        System.out.println("Upward Direction:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n---\n");

        System.out.println("Downward Direction (Stars):");
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int s = n - i; s > 0; s--) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
