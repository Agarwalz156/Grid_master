public class java_if_condition {
    public static void main(String[] args) {
        System.out.println("check even or odd");
        int num1 = 121;
        if (num1 % 2 == 0) {
            System.out.println("Num1 Is even " + num1);
        } else {
            System.out.println("Num1 Is odd" + num1);
        }

        System.out.println("Check The age ");
        int age = 12;

        if (age >= 18) {
            System.out.println("You are eligible.");
        } else {
            System.out.println("You are not eligible.");
        }
        System.out.println("Check the category of the student by marks :");
        int marks = 67;

        if (marks >= 90 && marks <= 100) {
            System.out.println("Category: Outstanding");
        } else if (marks >= 80 && marks < 90) {
            System.out.println("Category: Very Good");
        } else if (marks >= 70 && marks < 80) {
            System.out.println("Category: Good");
        } else if (marks >= 60 && marks < 70) {
            System.out.println("Category: Average");
        } else if (marks >= 0 && marks < 60) {
            System.out.println("Category: Pass");

        } else {
            System.out.println("Invalid marks! Please enter marks between 0 and 100.");
        }

        System.out.println("Swap two Number:");
        int num3 = 5;
        int num4 = 10;

        System.out.println("Before Swap:");
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);

        int temp = num3;
        num3 = num4;
        num4 = temp;

        System.out.println("After Swap:");
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);

        System.out.println("Find the whose age is Greater");
        int friend1 = 78;
        int friend2 = 92;
        int friend3 = 85;

        if (friend1 > friend2 && friend1 > friend3) {
            System.out.println("Friend 1 has the Bigger than Other: " + friend1);
        } else if (friend2 > friend1 && friend2 > friend3) {
            System.out.println("Friend 2  has the Bigger than Other: " + friend2);
        } else if (friend3 > friend1 && friend3 > friend2) {
            System.out.println("Friend 3 has the Bigger than Other: " + friend3);
        } else {
            System.out.println("Two or more friends have same Age.");
        }

        System.out.println("Switch Case");
        int size = 2;

        switch (size) {
            case 1:
                System.out.println("Extra Small");
                break;
            case 2:
                System.out.println("Small");
                break;
            case 3:
                System.out.println("Medium");
                break;
            case 4:
                System.out.println("Large");
                break;
            case 5:
                System.out.println("Extra Large");
                break;
            default:
                System.out.println("Invalid size number");
        }
    }
}