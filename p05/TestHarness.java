import java.util.Scanner;
import java.io.*;
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

        DSATree tree = new DSATree();

        String cvsSplitBy = ",";
        String filename = FileReader.enterFileName(); //enter name here
        String data[] = FileReader.readFile(filename);
        int arrayOfNum[] = FileReader.convertArrayI(data); 
        FileReader.printArray(arrayOfNum);
        
        for(int i=0; i< 3; i++)
        {
            tree.insert(String.valueOf(i),arrayOfNum[i]);
        }

        tree.printInOrder(tree.getRoot());    



        //tree.printInOrder(tree.getRoot());//prints tree in order L -> R




    }//end main
}
