import java.util.Arrays;

public class java_array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        int[] arr1;
        arr1 = new int[5];
        arr1[0] = 710;
        arr1[1] = 204;
        arr1[2] = 320;
        arr1[3] = 478;
        arr1[4] = 50;


        for (int i = 0; i < arr1.length; i++)
            System.out.println("Element at index " + i + " : " + arr[i]);

        int []arr2=arr1;
        int n1 = arr1.length;
        for (int l = 0; l < n1; l++)
            System.out.print(arr2[l] + " ");

        System.out.println(" ");

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr));

        int index= Arrays.binarySearch(arr1,478);
        System.out.println("Index of Given Key :" +index);

        int[]copy=Arrays.copyOf(arr,arr.length);
        System.out.println(" Copy the String"+Arrays.toString(copy));

        int[]copy2=Arrays.copyOfRange(arr ,1,4);
        System.out.println("Copy String from given Range "+ Arrays.toString(copy2));

        int []arr3 = new int[5];

        Arrays.setAll(arr3, i-> i*2);
        System.out.println("Array Using Set Condition:" + Arrays.toString(arr3));

    }
}
