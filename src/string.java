public class string {
    public static void main(String[] args) {
        String str1="Jaishree";
        String str2= new String("geeks");
        System.out.println(str1);
        System.out.println(str2);
        String str3="Radha" + " " +"Radha";
        System.out.println(str3);


        System.out.println("Use of stringBulider");

        StringBuilder sb = new StringBuilder("Power ranger Dino Victory charge");
        System.out.println("Initial StringBuilder: " + sb);

      sb.append(" is awesome!");
        System.out.println("After append: " + sb);

        sb.insert(13, " V-");
        System.out.println("After insert: " + sb);

         sb.replace(0, 5, "Super Power");
        System.out.println("After replace: " + sb);

          sb.delete(8, 14);
        System.out.println("After delete: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        int length1 = sb.length();
        System.out.println("Current length: " + length1);

        int capacity = sb.capacity();
        System.out.println("Current capacity: " + capacity);

       int length2 = sb.length();
        System.out.println("Current length: " + length2);



        int index1= sb.indexOf("yrotciV");
        System.out.println("Index of yrotciV"+index1);

        System.out.println(sb);

        int indexOfpower = sb.indexOf("Power");
        System.out.println("Index of 'super': " + indexOfpower);
        System.out.println(sb);

        char charAt5 = sb.charAt(5);
        System.out.println("Character at index 5: " + charAt5);

        sb.setCharAt(5, 'X');
        System.out.println("After setCharAt: " + sb);

        String substring = sb.substring(5, 10);
        System.out.println("Substring (5 to 10): " + substring);



        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb);

        String result = sb.toString();
        System.out.println("Final String: " + result);

    }
}
