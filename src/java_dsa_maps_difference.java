import java.util.*;

public class java_dsa_maps_difference {
    public static void main(String[] args) {
        int[] keys = {3, 71, 43, 5, 6};
        String[] values = {"Three", "Seventy-One", "Fourty-three", "Five", "Six"};

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], values[i]);
            linkedHashMap.put(keys[i], values[i]);
            treeMap.put(keys[i], values[i]);
        }

        System.out.println("HashMap (no specific order):");
        System.out.println(hashMap);

        System.out.println("\nLinkedHashMap (insertion order):");
        System.out.println(linkedHashMap);

        System.out.println("\nTreeMap (sorted by keys):");
        System.out.println(treeMap);

        System.out.println("TreeMap: Use firstKey() and lastKey()");
        System.out.println("\nTreeMap First Key: " + treeMap.firstKey());
        System.out.println("TreeMap Last Key: " + treeMap.lastKey());

        // First and last values
        System.out.println("TreeMap First Value: " + treeMap.get(treeMap.firstKey()));
        System.out.println("TreeMap Last Value: " + treeMap.get(treeMap.lastKey()));

        TreeMap<Integer, String> employees = new TreeMap<>();
        employees.put(103, "Alice");
        employees.put(101, "Bob");
        employees.put(102, "Charlie");
        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
