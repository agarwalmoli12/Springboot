class Hello{
    // default constructor
    Hello(){
        System.out.println("Hello World");
    }
    // parameterized constructor
    Hello(String name){
        System.out.println("Hello " + name);
    }
    // copy constructor
    Hello(Hello obj)//copied
    {
        System.out.println("Hello " + obj);
    }

}
public class Constructor {
    public static void main(String[] args) {
        System.out.println("OOPS in java");
        Hello obj1 =new Hello(); 
        Hello obj2 =new Hello("Moli");
        Hello obj3 =new Hello(obj2);
    }
}
