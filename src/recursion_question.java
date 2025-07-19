public class recursion_question {
    public static String reversestring(String str){
        if(str.isEmpty()){
            return str;
        }
        else{
            return reversestring(str.substring(1)+ str.charAt(0));
        }
    }
    public static void main(String[] args) {

        System.out.println(reversestring("Hello Beautiful"));
    }
}
// 