//import java.util.Scanner;

/**
 *
 * @author Caio Marteli
 */
public class Runner {


    public static void main(String[] args) 
    {
        Stack nums = new Stack();
        nums.push(12);
        nums.push(8);
        nums.push(10); //LIFO

        System.out.println(nums.pop());

        nums.show();
    }//end main

}
