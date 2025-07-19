public class java_string_ass06july {

    public static void main(String[] args) {
        String original = "Hello World!";
        String rev = "";


        for (int i = original.length() - 1; i >= 0; i--) {
            rev += original.charAt(i);
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + rev);


        System.out.println("String Iteration :");
        String sen = "I am beautiful";


        System.out.println("Character Iteration:");
        for (int i = 0; i < sen.length(); i++) {
            System.out.println("Character at index " + i + ": " + sen.charAt(i));
        }


        System.out.println("\nWord Iteration:");
        String[] words = sen.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.println("Word " + (i + 1) + ": " + words[i]);
        }
    }

}
