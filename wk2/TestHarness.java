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
        System.out.println("Checking if stack is empty Expected |TRUE| \nResult: "+ nums.isEmpty());
        nums.pop();
        nums.push(12.0);
        nums.push(8.0);
        nums.push(10.0);
        System.out.println("Checking if stack is empty Expected |FALSE| \nResult: "+ nums.isEmpty());
        
        System.out.println(nums.pop());

        nums.show();
        
        //Testing Circular Queue

        DSACircularQueue cq = new DSACircularQueue(); //default size 5
        cq.enqueue(1.7);
        cq.enqueue(2.0);
        cq.enqueue(3.69);
        cq.enqueue(4.0);
        cq.enqueue(5.0);
        cq.show();
        cq.dequeue();
        cq.enqueue(7.77);
        cq.show();
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(99.0);
        cq.show();


        //Testing Shuffling Queue


        DSAShufflingQueue sq = new DSAShufflingQueue(); //default size 5
        sq.enqueue(1.7);
        sq.enqueue(2.0);
        sq.enqueue(3.69);
        sq.enqueue(4.0);
        sq.enqueue(5.0);
        sq.show();
        sq.dequeue();
        sq.enqueue(7.77);
        sq.show();
        sq.dequeue();
        sq.dequeue();
        sq.enqueue(99.0);
        sq.show();
    }//end main

}
