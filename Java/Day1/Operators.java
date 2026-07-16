

public class Operators {
    public static void main(String[]args){
        System.out.println("Operators in Java");


        // Arithmetic Operators
        int a = 10;
        int b=20;

        System.out.println("Addition :" +(a+b));
        System.out.println("Subtraction :"+(a-b));
        System.out.println("Multiplication :"+(a*b));
        System.out.println("Division :"+(a/b));
        System.out.println("Modulus :"+(a%b));


        //Unary Operator
        System.out.println("Post-Increment :"+(a++));
        System.out.println("Pre-Increment :"+(++a));
        System.out.println("Post-Decrement :"+(b--));
        System.out.println("Pre-Decrement :"+(--b));




        //Logical Operators

        boolean X= true;
        boolean Y=false;
        System.out.println("AND :"+(X && Y));
        System.out.println("OR :"+(X || Y));
        System.out.println("NOT :"+(X != Y));



        // Ternary Operator
        int i=20, j=30, k=90, result;
        result = (i>j)?i:j ;
        System.out.println(result);

        //nested
        // to print minimum between 3 numbers

        int ans= ((i<j)?(i<k)?i:j :(j>k)?j:k );
        System.out.println(ans);


        //  instanceof Operator- for type checking
        String s="Agarwal";
        Object d='D';
        System.out.println(s instanceof String);
        System.out.println(d instanceof Integer);
    



    }
}
