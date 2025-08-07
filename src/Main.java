//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int num1 = 500;
        int num2 = 100;

        System.out.println("Arithmetic Operator: ");

        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));
        System.out.println("num1 / num2 = " + (num1 / num2));
        System.out.println("num1 % num2 = " + (num1 % num2));

        System.out.println("Postincrement : " + (num1++));
        System.out.println("Preincrement : " + (++num1));

        System.out.println("Postdecrement : " + (num2--));
        System.out.println("Predecrement : " + (--num2));

        System.out.println("Assigment Operator : ");

        System.out.println("num1 += 3: " + (num1 += 3));
        System.out.println("num1 -= 2: " + (num1 -= 2));
        System.out.println("num1 *= 4: " + (num1 *= 4));
        System.out.println("num1 /= 3: " + (num1 /= 3));
        System.out.println("num1 %= 2: " + (num1 %= 2));

        int num3 = 9;

        num3 ^= 4;
        System.out.println("num3 ^= 4: " + num3);
        num3 = 9;
        num3 &= 4;
        System.out.println("num3 &= 4: " + num3);
        num3 = 9;
        num3 |= 4;
        System.out.println("num3 |= 4: " + num3);


        System.out.println(" Relational Operators :");
        int num4 = 10;
        int num5 = 3;
        int num6 = 5;

        System.out.println("num4 > num5: " + (num4 > num5));
        System.out.println("num4 < num5: " + (num4 < num5));
        System.out.println("num4 >= num5: " + (num4 >= num5));
        System.out.println("num4 <= num5: " + (num4 <= num5));
        System.out.println("num4 == num6: " + (num4 == num6));
        System.out.println("num4 != num6: " + (num4 != num6));

        System.out.println("Bitwise Operator :");
        int num7 = 0b1010;
        int num8 = 0b1100;

        System.out.println("num7 & num8 : " + (num7 & num8));
        System.out.println("num7 | num8 : " + (num7 | num8));
        System.out.println("num7 ^ num8 : " + (num7 ^ num8));
        System.out.println("~num7 : " + (~num7));
        System.out.println("num7 << 2 : " + (num7 << 2));
        System.out.println("num8 >> 1 : " + (num8 >> 1));
        System.out.println("num8 >>> 1 : " + (num8 >>> 1));

        System.out.println("Shift Operators :");

        int num9 = 10;
        System.out.println("a<<1 : " + (num9 << 1));


        System.out.println("a>>1 : " + (num9 >> 1));

        String original = "racecar";

        String reversed = "";

        int length = original.length();

        for (int i = length - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original == reversed) {
            System.out.println(original + " is a Palindrome number.");
        } else {
            System.out.println(original + " is NOT a Palindrome number.");
        }
        System.out.println(Thread.currentThread().getName());

    }
}