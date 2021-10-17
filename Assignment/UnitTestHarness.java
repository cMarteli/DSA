/**
 *
 * @author Caio Marteli - September 2021
 * @author Caio Marteli - October 2021
 * UnitTestHarness Class
 */
// Marteli, C (2021) DSAPrac4 source code (Version 2.0) [Source code]. https://github.com/cMarteli/DSA
// previously submitted for DSAPrac4 Modified and improved October 2021 for gameofcatz.java
public class UnitTestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Testing Linked List:
        System.out.println("\n****Testing linked list****\n");
        DSALinkedList list = new DSALinkedList();
        System.out.println("TESTING isEmpty() Expected Output: |TRUE|");
        System.out.println("Actual Output:");
        System.out.println(list.isEmpty());
        list.insertLast("1");
        list.insertLast("2");
        list.insertFirst("3");
        list.insertFirst("4");
        list.insertFirst("5");
        list.insertLast("6");
        System.out.println("TESTING insert methods. Expected Output: 5 4 3 1 2 6");
        System.out.println("Actual Output:");
        list.show(); //iterator used here
        System.out.println("TESTING peeks method. Expected Output: 5 then 6");
        System.out.println("Actual Output:");
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println("TESTING isEmpty() Expected Output: |FALSE|");
        System.out.println("Actual Output:");
        System.out.println(list.isEmpty());
        System.out.println("Removing first:");
        list.removeFirst();
        System.out.println("TESTING iterator. Expected Output: 4 3 1 2 6");
        list.show();
        try {
            System.out.println("TESTING search. Expected Output: Could not find");
            list.search("7");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("TESTING search. Expected Output: Memory address of a node");
           System.out.println(list.search("6"));
        System.out.println("TESTING removeAt. Removed: "+ list.removeAt("3") +" Expected Output: 4 1 2 6");
            list.show();
            System.out.println("TESTING removeAt. Removed: "+ list.removeAt("6") +" Expected Output: 4 1 2");
            list.show();

        //Testing Stack
        System.out.println("\n****Testing Stack****\n");
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

        //Testing Queue
        System.out.println("\n****Testing Queue****\n");
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
