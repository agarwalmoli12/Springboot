public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("Polymorphism in java");


        Parent p;
        p = new child1();
        p.Print();

        p = new child2();
        p.Print();

        System.out.println(Calc.Add(20, 46));
        System.out.println(Calc.Add(5.59, 86.5));

    }
}

// Method Overriding

class Parent {
    void Print() { 
        System.out.println("parent class"); }
}
class child1 extends Parent {
    void Print() { 
        System.out.println("child1"); }
}
class child2 extends Parent {

    // Method
    void Print() { System.out.println("child2"); }
}


// Method Overloading 
class Calc {
    static int Add(int a, int b){
        return a + b;
    }
    static double Add(double a, double b){
        return a + b;
    }
}
