public class Inheritance {
    public static void main(String[] args) {
        System.out.println("Interitance in java");
        Animal a;
        a = new Dog();
        a.sound();  

        a = new Cat();
        a.sound(); 

        
        AmphibiousVehicle obj = new AmphibiousVehicle();
        obj.waterInfo();
        obj.landInfo();
    
    }
    
}


class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}


class Dog extends Animal {
    void sound() {
        System.out.println("barks");
    }
}


class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}



    


// MULTIPLE INHERITANCE
interface LandVehicle {
    default void landInfo() {
        System.out.println("This is a LandVehicle");
    }
}
interface WaterVehicle {
    default void waterInfo() {
        System.out.println("This is a WaterVehicle");
    }
}

class AmphibiousVehicle implements LandVehicle, WaterVehicle {
    AmphibiousVehicle() {
        System.out.println("This is an AmphibiousVehicle");
    }
}