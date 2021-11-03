import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 *
 * @author Caio Marteli 19598552
//  */
public class FileReader {

    public static final int MAX_HEAP_SIZE = 200; //TODO: Hardcoded limit

    /************************************************************
    IMPORT: objToSave(ContainerClass), filename(String)
    EXPORT: none
    ASSERTION: Gets filename and performs the associated task while handling invalid inputs
    ************************************************************/
   public static void save(DSAMaxHeap objToSave, String filename)
   {
      FileOutputStream fileStrm;
      ObjectOutputStream objStrm;

      try
      {
         fileStrm = new FileOutputStream(filename);   //Underlying stream
         objStrm = new ObjectOutputStream(fileStrm);    //Object serialization stream
         objStrm.writeObject(objToSave);    //Serialize and save to filename
         objStrm.close();//Clean up
      }
      catch (Exception e)
      {  //catches filenot found exception
         throw new IllegalArgumentException("Unable to save object to file" + e);
      }
   }

   /************************************************************
    IMPORT: filename(String)
    EXPORT: inObj(ContainerClass) - serialized file
    ASSERTION: Gets filename and performs the associated task while handling invalid inputs
    ************************************************************/

   public static DSAMaxHeap load(String filename) throws IllegalArgumentException
   {
      FileInputStream fileStrm;
      ObjectInputStream objStrm;
      DSAMaxHeap inObj = null;
      try
      {
         fileStrm = new FileInputStream(filename);//Underlying stream
         objStrm = new ObjectInputStream(fileStrm);//Object serialization stream
         inObj = (DSAMaxHeap)objStrm.readObject();//Deserialize. Note the cast is needed
         objStrm.close();//Clean up
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class not found: " + e);
      }
      catch (Exception e)
      {
         throw new IllegalArgumentException("Unable to load object from file");
      }
      return inObj;

    }

/************************************************************
IMPORT: filename (String)
EXPORT: graph (DSAGraph)
ASSERTION: Imports a text file and writes it to a graph
************************************************************/
public static DSAMaxHeap readFile(String filename)
    {
        DSAMaxHeap T = new DSAMaxHeap(MAX_HEAP_SIZE); //TODO: Hardcoded limit
        System.out.println("Reading file: " + filename);
        try {
            File inFile = new File(filename);
            Scanner sc = new Scanner(inFile);
            sc.useDelimiter(",");

            while(sc.hasNextLine())
            {
                //this pads the string with 0s so the string comparison doesn't break
                int key = Integer.parseInt(sc.next());
                T.insert(key);
            }
            sc.close();
        } catch (Exception e) //file not found
        {
            throw new IllegalArgumentException("Unable to load object from file" + e.getMessage());
        }

        return T;


    }//end readfile()

    //Manual file name option
    public static String enterFileName(String defa)
    {
        String prompt = "Would you like to enter a file name? Y/N";
        Scanner sc1 = new Scanner(System.in);
        String fileName;
        char userAnswer;
        do
        {
            System.out.println(prompt);
            prompt = "Please enter Y or N";
            userAnswer = Character.toUpperCase(sc1.next().charAt(0));
        }
        while (userAnswer != 'Y' && userAnswer != 'N');

        if (userAnswer == 'Y')
        {
            prompt = "Enter file Name:";
            System.out.println(prompt);
            fileName = sc1.next() + ".csv";
            sc1.close();

        }
        else
        {
            fileName = defa; //Sets filename to default
        }
        return fileName;
    }


}