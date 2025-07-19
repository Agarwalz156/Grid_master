import java.util.Arrays;
import java.util.Scanner;

public class Java_2D_array {
    public static void main(String args[])
    {
        int arr[][] = { { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };
        System.out.println("Printing 2D Arrays Using Deeptostring methods");
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Printing 2D Arrays  Using For loop");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr[i][j] + " ");

            System.out.println();
        }
        int[][] arr1 = new int[3][3];
        arr1[0][0]=3;
        arr1[0][1]=3;
        arr1[1][2]=3;
        arr1[1][0]=3;
        arr1[1][1]=3;
        arr1[2][2]=3;
        arr1[2][0]=3;
        arr1[2][1]=3;
        arr1[0][2]=3;

        System.out.println("Print 2D Arrays ");
        System.out.println("Rows : " + arr1.length);
        System.out.println("Columns : " + arr1[0].length);
        System.out.println(Arrays.deepToString(arr1));
        System.out.println("Element on given index:- "+ arr1[0][2]);

        System.out.println("Print String 2D ");

        String arr2[][] = {
                { "Apple", "Banana", "Cherry" },
                { "Dog", "Elephant", "Frog" },
                { "Grape", "Horse", "Igloo" }
        };

        System.out.println("Printing 2D Arrays Using deepToString method:");
        System.out.println(Arrays.deepToString(arr2));

        System.out.println("\nPrinting 2D Arrays Using For loop:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr2[i][j] + " ");
            System.out.println();
        }

        String[][] arr3 = new String[3][3];
        arr3[0][0] = "A";
        arr3[0][1] = "B";
        arr3[0][2] = "C";
        arr3[1][0] = "D";
        arr3[1][1] = "E";
        arr3[1][2] = "F";
        arr3[2][0] = "G";
        arr3[2][1] = "H";
        arr3[2][2] = "I";

        System.out.println("\nPrint 2D Arrays:");
        System.out.println("Rows : " + arr3.length);
        System.out.println("Columns : " + arr3[0].length);
        System.out.println(Arrays.deepToString(arr3));
        System.out.println("Element on given index:- " + arr3[0][2]);

        System.out.println();/*
        Scanner scann= new Scanner(System.in);
        System.out.println("Enter your String");
        String name=scann.nextLine();
        System.out.println("Given Name:-"+name);
        System.out.println("Enter your Number");
        int num=scann.nextInt();
        System.out.println("Print Given Number:- "+num);
        System.out.println("Enter your Double:");
        double d = scann.nextDouble();
        System.out.println("Given Double: " + d);

        // Long input
        System.out.println("Enter your Long:");
        long l = scann.nextLong();
        System.out.println("Given Long: " + l);

        // Float input
        System.out.println("Enter your Float:");
        float f = scann.nextFloat();
        System.out.println("Given Float: " + f);

        // Boolean input
        System.out.println("Enter your Boolean (true/false):");
        boolean b = scann.nextBoolean();
        System.out.println("Given Boolean: " + b);

        System.out.println("Enter the Student Data :- ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Class (numeric): ");
        int studentClass = sc.nextInt();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Marks: ");
        float marks = sc.nextFloat();

        System.out.print("Enter Section (A/B/C...): ");
        char section = sc.next().charAt(0);
        sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.println("\n--- Student Details ---");
        System.out.println("Name     : " + name);
        System.out.println("Class    : " + studentClass);
        System.out.println("Age      : " + age);
        System.out.println("Marks    : " + marks);
        System.out.println("Section  : " + section);
        System.out.println("Address  : " + address);

        sc.close();
*/

        if(args.length!=2){
            System.out.println("usage: java commandline <name><age>");
            return;
        }
        String name=args[0];
        int age=Integer.parseInt(args[1]);

        System.out.println("Hello"+"!you are"+ age +"years odd");
    }
}
