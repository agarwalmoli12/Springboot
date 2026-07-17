
import java.util.*;
public class Methods {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = 10;
        int b = 20;
        int sum = add(a, b);
        System.out.println("Sum: " + sum);
        gfg obj1 = new gfg();
        obj1.Hello();
        Array obj2 = new Array();
        System.out.println("Enter the size of the array: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        Array.sumarray(arr);

    }

    public static int add(int x, int y) {
        return x+y;
    }


static class gfg{
    public void Hello(){
        System.out.println("Hello World");
    }
}


static class Array{
    public static int sumarray(int[]arr){
        int sum =0;
        for(int i=0; i<arr.length;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
        return sum;
    }
}

}

