package assignment_package;

import java.util.Arrays;
import java.util.Scanner;

public class java_array_assgni_09july {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Greatest element in 1D array");
            System.out.println("Enter size of 1D array:");
            int size = sc.nextInt();
            int[] arr1D = new int[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr1D[i] = sc.nextInt();
            }

            int max = arr1D[0];
            for (int i = 1; i < size; i++) {
                if (arr1D[i] > max) {
                    max = arr1D[i];
                }
            }
            System.out.println("Greatest number in array: " + max);

            System.out.println("Create matrix 4x3 and take input from user");
            int[][] matrix = new int[4][3];
            System.out.println("Enter elements for 4x3 matrix:");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.println("Printing the Matrix ");
            System.out.println("Matrix 4x3 is:");
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println("Reverse the 1D array0");
            System.out.println("Reversed array:");
            for (int i = size - 1; i >= 0; i--) {
                System.out.print(arr1D[i] + " ");
            }
            System.out.println();

            System.out.println("Find minimum value in 1D array");
            int min = arr1D[0];
            for (int i = 1; i < size; i++) {
                if (arr1D[i] < min) {
                    min = arr1D[i];
                }
            }
            System.out.println("Minimum value in array: " + min);

            System.out.println("Check if two arrays are equal");
            System.out.println("Enter size of second array:");
            int size2 = sc.nextInt();
            int[] arr2 = new int[size2];

            System.out.println("Enter elements of second array:");
            for (int i = 0; i < size2; i++) {
                arr2[i] = sc.nextInt();
            }

            boolean areEqual = Arrays.equals(arr1D, arr2);
            System.out.println("Are both arrays equal? " + areEqual);

            System.out.println("User input two matrices and add them");
            System.out.println("Enter number of rows and columns for matrix addition:");
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            int[][] m1 = new int[rows][cols];
            int[][] m2 = new int[rows][cols];
            int[][] sum = new int[rows][cols];

            System.out.println("Enter first matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    m1[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter second matrix:");
            for (int i = 0; i < rows ; i++) {
                for (int j = 0; j < cols; j++) {
                    m2[i][j] = sc.nextInt();
                }
            }

            System.out.println("Sum of two matrices:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i][j] = m1[i][j] + m2[i][j];
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }

            sc.close();
        }


}
