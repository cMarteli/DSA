//import java.util.Scanner;

/**
 *
 * @author Caio Marteli
 */
public class TestHarness {


    public static void main(String[] args) 
    {
        //Testing Stack

        DSAStack nums = new DSAStack();
        System.out.println("Checking if stack is empty Expected |TRUE| \n Result: "+ nums.isEmpty());
        nums.pop();
        nums.push(12.0);
        nums.push(8.0);
        nums.push(10.0); //LIFO
        System.out.println("Checking if stack is empty Expected |FALSE| \n Result: "+ nums.isEmpty());
        
        System.out.println(nums.pop());

        nums.show();
    }//end main

}
