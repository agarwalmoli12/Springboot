
public class oop {
    
    public static void main(String[] args) {

        System.out.println("OOPS in java");

        TV obj = new TVRemote();
        obj.TurnOff();
        obj.TurnOn();


        Encapsulation e = new Encapsulation();
        e.setName("Moli Agarwal");
        System.out.println("Name is :"+ e.getName());

    }


    // There are 4 pillars of OOPS 


    // 1. Abstraction

    static abstract class TV{
        abstract void TurnOn();
        abstract void TurnOff();
    }
    static class TVRemote extends TV{
        @Override
        void TurnOn(){
            System.out.println("TV is On");

        }
        @Override
        void TurnOff(){
            System.out.println("TV is off");
        }

    }

    




    // 2. Encapsulation

    static class Encapsulation{
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }


    // 3. Inheritance





    // 4. Polymorphism
}
