//import java.util.Scanner;

/**
 *
 * @author Caio Marteli
 */
public class TestHarness {


    public static void main(String[] args) 
    {
        //Testing Stack

        /*
        DSAStack nums = new DSAStack();
        System.out.println("Checking if stack is empty Expected |TRUE| \n Result: "+ nums.isEmpty());
        nums.pop();
        nums.push(12.0);
        nums.push(8.0);
        nums.push(10.0); //LIFO
        System.out.println("Checking if stack is empty Expected |FALSE| \n Result: "+ nums.isEmpty());
        
        System.out.println(nums.pop());

        nums.show();
        */

        DSACircularQueue q = new DSACircularQueue(5); //default size 5
        q.enqueue(1.7);
        q.enqueue(2.0);
        q.enqueue(3.69);
        q.enqueue(4.0);
        q.enqueue(5.0);
        q.show();
        q.dequeue();
        q.enqueue(7.77);
        q.show();
        //q.dequeue();

    }//end main

}
