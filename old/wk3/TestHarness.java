import java.util.Scanner;




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

        DSALinkedList list = new DSALinkedList();
        list.insertLast(1);
        list.insertLast("2");
        list.insertFirst("3");
        list.insertFirst("4");
        list.insertFirst("5");
        list.insertLast(6);

        list.show();

        System.out.println(list.peekFirst());        



    }//end main
}
