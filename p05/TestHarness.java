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
     
        
        DSATree tree = new DSATree();
        //tree.printRoot();

        tree.insert("1",12);
        tree.insert("2",89);
        tree.insert("3",20);
        //tree.printRoot();

        tree.printInOrder(tree.getRoot());



    }//end main
}
