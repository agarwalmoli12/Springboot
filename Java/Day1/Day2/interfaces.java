import java.io.*;
public class interfaces {
    public static void main(String[] args) {
        System.out.println("implementing interfaces in java");
        Bike b = new Bike();
        b.changegear(5);
        b.changespeed(6);
        b.applybrakes();
        b.print();

        C c = new C();
        c.method1();
        c.method2();
        c.method3();

    }
}
    interface Vehicle{
        void changegear(int a);
        void changespeed(int a);
        void applybrakes();
    }
    class Bike implements Vehicle{
        int speed;
        int gear;

        @Override
        public void changegear(int newgear)
         {
            gear=newgear;
        }


        @Override
        public void changespeed(int newspeed) {
            speed=newspeed;
        }

        @Override
        public void applybrakes() {
            System.out.println("Brakes Applied");
        }
        public void print(){
            System.out.println("Speed is :"+speed);
            System.out.println("Gear is :"+gear);
        }
    }


    interface A{
        void method1();
        void method2();
    }
    
    
        
    interface B extends A{
        void method3();
    }

    class C implements B{
        public void method1() {
        System.out.println("Method 1");
    }
  
    public void method2() {
        System.out.println("Method 2");
    }
  
    public void method3() {
        System.out.println("Method 3");
    }

    }



    
    

