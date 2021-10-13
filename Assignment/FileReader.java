import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 *
 * @author Caio Marteli 19598552
//  */
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
         throw new IllegalArgumentException("Unable to save object to file" + e); 
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
         throw new IllegalArgumentException("Unable to load object from file"); 
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
        //System.out.println("Reading text file");
        File inFile = new File(filename);

        try {
            System.out.println("Reading file: " + filename);
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
                    //System.out.println("Added label:" + label);
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



        } catch (FileNotFoundException e) {
            // handle exception
            e.printStackTrace();
        }

        return graph;
     

    }//end readfile()

    //Manual file name option
    public static String enterFileName()
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
            fileName = OUTPUT_FILENAME; //Sets filename to default
        }
        return fileName;
    }
}