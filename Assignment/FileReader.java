import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
/**
 * FileReader.java
 * @author Caio Marteli (19598552)
*/
// Marteli, C (2021) OOPD source code (Version 1.0) [Source code]. https://github.com/cMarteli/
// # previously submitted for OOPD Modified and improved October 2021 for gameofcatz.java
public class FileReader {

    public static final String OUTPUT_FILENAME = "savefile.txt";


    /************************************************************
    IMPORT: objToSave(ContainerClass), filename(String)
    EXPORT: none
    ASSERTION: Gets filename and performs the associated task while handling invalid inputs
    ************************************************************/
   public static void save(DSAGraph objToSave, String filename)
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
      {  //should do more here
         throw new IllegalArgumentException("Unable to save object to file: " + e);
      }
   }

    /************************************************************
    IMPORT: objToSave(ContainerClass), filename(String)
    EXPORT:
    ASSERTION:
    ************************************************************/
    public static void saveOutput(DSALinkedList list, String filename)
    {
       try
       {
           PrintWriter out = new PrintWriter(filename);

           out.println();

           if(!list.isEmpty())
           {
               System.out.println("Displaying routes:");
               Iterator<DSAQueue> itr = list.iterator();
               int counter = 0;
               while(itr.hasNext())
               {
                   counter ++;
                   out.println("\nRoute number: [" + counter + "]");
                   itr.next().show();
               }
           }
           else
           {
               out.println("Route list is empty.");
           }

           out.close();
       }
       catch (Exception e)
       {  //should do more here might not be needed
          throw new IllegalArgumentException("Unable to print object to file: " + e);
       }

    }

   /************************************************************
    IMPORT: filename(String)
    EXPORT: inObj(ContainerClass) - serialized file
    ASSERTION: Gets filename and performs the associated task while handling invalid inputs
    ************************************************************/

   public static DSAGraph load(String filename) throws IllegalArgumentException
   {
      FileInputStream fileStrm;
      ObjectInputStream objStrm;
      DSAGraph inObj = null;
      try
      {
         fileStrm = new FileInputStream(filename);//Underlying stream
         objStrm = new ObjectInputStream(fileStrm);//Object serialization stream
         inObj = (DSAGraph)objStrm.readObject();//Deserialize.
         objStrm.close();//Clean up
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class not found: " + e);
      }
      catch (Exception e)
      {
        throw new IllegalArgumentException("Unable to load object from file: " + e.getMessage());
      }
      return inObj;

    }


/************************************************************
IMPORT: filename (String)
EXPORT: graph (DSAGraph)
ASSERTION: Imports a text file and writes it to a graph
************************************************************/
public static DSAGraph readFile(String filename)
    {
        DSAGraph graph = new DSAGraph();
        System.out.println("Reading file: " + filename);
        try {
            File inFile = new File(filename);
            Scanner sc = new Scanner(inFile);
            sc.skip("#"); //skips comment at beggining
            //sc.useDelimiter(" ");

            while(sc.hasNextLine())
            {
                //sc.nextLine(); //currently always skipping the first line
                String command = sc.next();

                if(command.equals("Node"))//case finds NODE
                {
                    //System.out.println("Found node");
                    String label = sc.next();
                    //String code = sc.next();
                    //System.out.println("Added label:" + label);
                    //graph.addVertex(label,code);
                    graph.addVertex(label);
                }
                else if(command.equals("Edge")) //case finds EDGE
                {
                    //System.out.println("Found Edge");
                    String l1 = sc.next();
                    String l2 = sc.next();
                    //System.out.println("Added edges:" + l1 + " and " + l2);
                    graph.addEdge(l1, l2);
                }
                else if(command.equals("#"))
                {
                    System.out.println("Comment line"); //TODO: currently crashes if there's a comment after the '#'
                }

            }
            sc.close();
        } catch (Exception e) //file not found
        {
            throw new IllegalArgumentException("Unable to load object from file" + e.getMessage());
        }

        return graph;


    }//end readfile()

}