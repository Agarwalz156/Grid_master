public class java_function {
    static void string_print(){
        System.out.println("Try Something New !!");
    }
    static int Sum(int num1,int num2){
        return num1+num2;
    }
    public static class dif_return
    {
        public int printMessage(int x) {

            System.out.println("Value of X:- "+x);
            return x;
        }
}
    public static class GFG {
        int sum_of_number(int n)
        {
            int result;

            if (n == 1)
                return 1;
            result =sum_of_number(n - 1) + n;
            return result;
        }

        // recursive method
        int fact(int n)
        {
            int result;

            if (n == 1)
                return 1;
            result = fact(n - 1) * n;
            return result;
        }
    }

        public static void main(String[] args) {
        System.out.println("Function Calling:-");
        string_print();
        int sum_of_num=Sum(34,45);
        System.out.println("Sum of Given number:-"+sum_of_num);

            System.out.println("Function Call by object creation");
            dif_return obj = new dif_return();

            // Calling the method
            obj.printMessage(56);


            System.out.println("Recursion In Java :-");

            GFG f = new GFG();

            System.out.println("Factorial of 3 is "
                    + f.fact(3));
            System.out.println("Factorial of 4 is "
                    + f.fact(4));
            System.out.println("Factorial of 5 is "
                    + f.fact(5));
            System.out.println("Sum of Given Natural Number :" +f.sum_of_number(5));
        }
}
