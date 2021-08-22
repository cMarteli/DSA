import java.util.*;

/**
 *
 * @author Caio Marteli
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize variables

        DSALinkedList<String> list = new DSALinkedList<String>();

        System.out.println("TESTING isEmpty() Expected Output: TRUE");
        System.out.println("Actual Output:");
        System.out.println(list.isEmpty());

        list.insertLast("1");
        list.insertLast("2");
        list.insertFirst("3");
        list.insertFirst("4");
        list.insertFirst("5");
        list.insertLast("6");

        //System.out.println(list.peekLast());

        System.out.println("TESTING insert methods. Expected Output: 5 4 3 1 2 6");

        System.out.println("Actual Output:");
        //list.show();
        iterateOverList(list); //iterator used here

        System.out.println("TESTING peeks method. Expected Output: 5 then 6");

        System.out.println("Actual Output:");

        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());

        System.out.println("TESTING isEmpty() Expected Output: FALSE");
        System.out.println("Actual Output:");
        System.out.println(list.isEmpty());    

        System.out.println("Removing first:");
        list.removeFirst();
        //System.out.println("Removing last:");
        //list.removeLast();
        //list.show();
        iterateOverList(list);

    }//end main

    public static void iterateOverList(DSALinkedList<String> theList) 
    {
        String c;
        Iterator<String> iter = theList.iterator();
        
        while (iter.hasNext())
        {       
            c = iter.next(); //iterates over list
            System.out.println(c);
        } 
    } 
}
