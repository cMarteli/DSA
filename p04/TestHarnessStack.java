/**
 *
 * @author Caio Marteli 19598552
 */
public class TestHarnessStack {


    public static void main(String[] args) 
    {
        //Testing Stack

        DSAStack nums = new DSAStack();
        System.out.println("Checking if stack is empty, expected: |TRUE| \nResult: "+ nums.isEmpty());
        //nums.pop(); //Should throw exception
        System.out.println("Push 12.0");        
        nums.push(12.0); 
        System.out.println("Push 8.0");
        nums.push(8.0);
        System.out.println("Push 10.0");
        nums.push(10.0);
        System.out.println("Real output:");
        nums.show();
        //System.out.println("Current top of Stack:"+ nums.peek());
        System.out.println("Checking if stack is empty, expected: |FALSE| \nResult: "+ nums.isEmpty());
        
        System.out.println("Pop ->" + nums.pop());
        //System.out.println("Current top of Stack:"+ nums.peek());
        //nums.show();
        System.out.println("Pop ->" + nums.pop());
        //nums.show();
        System.out.println("Pop ->" + nums.pop());
        nums.show();
        //nums.pop();

        System.out.println("Checking if stack is empty, expected: |TRUE| \nResult: "+ nums.isEmpty());        
        
        //Testing Circular Queue

        DSAQueue cq = new DSAQueue();
        //cq.dequeue();
        System.out.println("Checking if queue is empty, expected: |TRUE| \nResult: "+ cq.isEmpty());
        cq.enqueue(1.7);
        cq.enqueue(2.0);
        cq.enqueue(3.69);
        cq.enqueue(4.0);
        cq.enqueue(5.0);
        cq.show();
        System.out.println("Checking if queue is empty, expected: |FALSE| \nResult: "+ cq.isEmpty());
        System.out.println("Dequed >> " +cq.dequeue());        
        cq.show();
        System.out.println("Queued >> 7.77");
        cq.enqueue(7.77);
        //cq.dequeue();
        //cq.dequeue();
        System.out.println("Queued >> 99.0");
        cq.enqueue(99.0);
        cq.show();

    }//end main

}
