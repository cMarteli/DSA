/**
 *
 * @author Caio Marteli - September 2021
 * @author Caio Marteli - October 2021
 * UnitTestHarness Class
 */
// Marteli, C (2021) DSAPrac4 source code (Version 2.0) [Source code]. https://github.com/cMarteli/DSA
// Modified and improved October 2021 for gameofcatz.java
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize variables


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
        System.out.println("TESTING removeAt. Expected Output: 4 1 2 6");
            list.removeAt("3");
            list.show();
            System.out.println("TESTING removeAt. Expected Output: 4 1 2");
            list.removeAt("6");
            list.show();

    }//end main
}
