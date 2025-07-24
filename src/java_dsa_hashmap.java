import java.util.*;

public class java_dsa_hashmap {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println("Size: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());

        System.out.println("apple = " + map.get("apple"));
        System.out.println("banana = " + map.get("banana"));

        map.put("apple", 50);
        System.out.println("apple (updated) = " + map.get("apple"));

        System.out.println(map);
        map.remove("banana");
        System.out.println("banana exists? " + map.containsKey("banana"));
        System.out.println(map);
        System.out.println("Size after removing banana: " + map.size());

        map.clear();
        System.out.println("Map cleared.");
        System.out.println("Size after clear: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());

        System.out.println("\n-----------------------------");

        // Task 1: Student Marks
        studentMarks();

        // Task 2: First non-repeating character
        String inputStr = "swiss";
        firstNonRepeatingChar(inputStr);

        // Task 3: Most frequent element in array
        int[] numbers = {1, 3, 2, 3, 4, 5, 3, 2,2,2,2, 4};
        mostFrequentElement(numbers);
    }

    // 1. Store and display marks of students
    public static void studentMarks() {
        HashMap<String, Integer> marks = new HashMap<>();
        marks.put("Alice", 85);
        marks.put("Bob", 92);
        marks.put("Charlie", 78);
        marks.put("David", 85);

        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    // 2. Find first non-repeating character
    public static void firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                System.out.println("First non-repeating character: " + ch);
                return;
            }
        }
        System.out.println("No non-repeating character found.");
    }

    // 3. Find most frequent element in an array
    public static void mostFrequentElement(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int mostFrequent = -1;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("Most frequent element: " + mostFrequent + " (appears " + maxCount + " times)");
    }
}
