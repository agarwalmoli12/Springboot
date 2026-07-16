public class Conditions {
    public static void main(String []args){
        System.out.println("Conditional Statements in Java");
        
        int a= 10;
        int b=20;


        // IF

        if(a<15){
            System.out.println("a is smaller than 15");
        }

        // If-else
        if(a>b){
            System.out.println(a+ "is greater than " +b);
        } 
        else{
            System.out.println(a+ " is lesser than " +b);

        }   

        int age=56;
        if(age>18){
            System.out.println("Eligible to vote");
        }
        else{
            System.out.println("Not eligible to Vote");
        }

        if(a==12){
            System.out.println("a value is 12");
        }
        else if(a==15){
            System.out.println("a value is 15");
        }
        else{
            System.out.println("a is not present");
        }


        // Switch statement


        int day=1;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;  
            case 4:
                System.out.println("Thursday");
                break;  
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;            
            default:
                System.out.println("Invalid Number");    
        }
    }
}
