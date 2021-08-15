//import java.util.Scanner;

/**
 *
 * @author Caio Marteli 19598552
 */
public class TestHarness {


    public static void main(String[] args) 
    {
        //Testing Stack
        DSAStack callStack = new DSAStack(20); //string stack to emulate how a call stack works
        callStack.push("public static void main(String[] args)"); //Main gets put on stack

        DSAStack nums = new DSAStack(); //Using default, size 5 
        DSAStack nums2 = new DSAStack(8); //Using alternate size 8
        System.out.println("Checking if stack is empty, expected: |TRUE| \nResult: "+ nums.isEmpty());
        //nums.pop(); //Should throw exception
        nums.push(12.0);
        callStack.push("nums.push(12.0)");
        nums.push(8.0);
        callStack.push("nums.push(8.0)");
        nums.push(10.0);
        callStack.push("nums.push(10.0)");
        System.out.println("Current top of Stack:"+ nums.peek());
        System.out.println("Checking if stack is empty, expected: |FALSE| \nResult: "+ nums.isEmpty());
        
        System.out.println("Pop ->" + nums.pop());
        System.out.println("Current top of Stack:"+ nums.peek());

        nums.show();
        
        //Testing Circular Queue

        DSACircularQueue cq = new DSACircularQueue(); //Using default, size 5 
        DSACircularQueue cq2 = new DSACircularQueue(8); //Using alternate size 8
        System.out.println("Checking if Circular queue is empty, expected: |TRUE| \nResult: "+ cq.isEmpty());
        cq.enqueue(1.7);
        cq.enqueue(2.0);
        cq.enqueue(3.69);
        cq.enqueue(4.0);
        cq.enqueue(5.0);
        cq.show();
        System.out.println("Checking if Circular queue is empty, expected: |FALSE| \nResult: "+ cq.isEmpty());
        cq.dequeue();
        cq.enqueue(7.77);
        cq.show();
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(99.0);
        cq.show();


        //Testing Shuffling Queue

        DSAShufflingQueue sq = new DSAShufflingQueue(); //Using default, size 5 
        DSAShufflingQueue sq2 = new DSAShufflingQueue(8); //Using alternate size 8
        System.out.println("Checking if Shuffling queue is empty, expected: |TRUE| \nResult: "+ sq.isEmpty());
        sq.enqueue(1.7);
        sq.enqueue(2.0);
        sq.enqueue(3.69);
        sq.enqueue(4.0);
        sq.enqueue(5.0);
        sq.enqueue(98.0); //Should say queue is full
        System.out.println("Checking if Shuffling queue is empty, expected: |FALSE| \nResult: "+ sq.isEmpty());
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
