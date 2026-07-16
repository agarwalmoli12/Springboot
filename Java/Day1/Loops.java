public class Loops {
    public static void main(String[]args){
        System.out.println("Loops In java");

        //FOR LOOP

        for(int i=0;i<5;i++){
            System.out.println("First five numbers :"+i);
        }

        for(int i=0; i<=5;i++){
            System.out.println(i*2);
        }

        //WHILE LOOP

        int i=10;
        while(i<=20){
            System.out.println(i);
        
        i++;
        }


        //DO-WHILE LOOP

        int j=10;
        do{
            System.out.println(j);
            j++;
        }
        while(i<+20);



        // For-Each Loop


        String a[]={"Apple","Cheery","Mango"};
        for (String fruits :a){
            System.out.println("FRUITS :"+fruits);

        }



    }
}
