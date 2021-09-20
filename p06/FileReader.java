import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 *
 * @author Caio Marteli 19598552
//  */
public class FileReader {

    public static final String SERIAL_FILENAME = "serial.txt", INPUT_CSV_FILENAME = "input.csv", OUTPUT_CSV_FILENAME = "output.csv";


    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public static void menu(DSAGraph graph)
    {
        String prompt = 
        "What would you like to do?\n [1]Read a serialized file\n [2]Read a csv file\n [3]Display the tree\n [4]Write a serialized file\n [5]Write a csv file\n [6]Exit\n";
        String usrStr = " ";
        String data[];
       // int arrayOfNum[];
        int userSelect = 0;
        Scanner sc = new Scanner(System.in);
        while(userSelect != 6)
        {
            do
            {
                System.out.println(prompt);
                usrStr = sc.next();
                userSelect = Integer.valueOf(usrStr);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 5 && userSelect != 6);
                               

            //case statement to choose required method
            switch (userSelect)
            {
                case 1: 
                {   //User choice: Read a serialized file         
                    // System.out.println("LOAD!");
                    // //filename = enterFileName(); //enter name here
                    // tree = load(SERIAL_FILENAME);           
                }
                break;

                case 2:
                {  //User choice: Read from csv
                    
                    //filename = enterFileName(); //enter name here
                    data = readFile(INPUT_CSV_FILENAME);
                    //arrayOfNum = FileReader.convertArrayI(data);
                    System.out.println("Reading from CSV" + INPUT_CSV_FILENAME + "...");
                    try {
                        // tree.insert("E",arrayOfNum[0]);
                        // tree.insert("B",arrayOfNum[1]);
                        // tree.insert("A",arrayOfNum[2]);
                        // tree.insert("D",arrayOfNum[3]);
                        // tree.insert("C",arrayOfNum[4]);
                        // tree.insert("F",arrayOfNum[5]);
                        
                    } catch (IllegalArgumentException e) {
                        //catches if key already exists
                        System.out.println(e.getMessage());
                    }              
                    // for(int i=0; i< arrayOfNum.length; i++)
                    // {
                    //     tree.insert(String.valueOf(i),arrayOfNum[i]);
                    // }
                }
                break;

                case 3: 
                {   //User choice: Display the list
                    System.out.println("DISPLAY");
                    // tree.display();


                   // String target = "2";
                    
                    try {
                    //System.out.println("Searching for value at index: " + target);
                    //System.out.println("Result: " + tree.find(target));
                    // System.out.println("Tree depth: "+ tree.height());
                    // System.out.println("Tree max: "+ tree.find(tree.max(tree.getRoot())));
                    
                    // System.out.println("Tree min: "+ tree.find(tree.min(tree.getRoot())));
                        
                    } catch (NoSuchElementException ex) {
                        //Not found
                        System.out.println(ex.getMessage());
                    }


                }
                break;

                case 4: 
                {   //User choice: Write a serialized file
                    System.out.println("SAVE");
                    // save(tree, SERIAL_FILENAME);

 
                }
                break;

                case 5: 
                {   //User choice: Write a serialized file
                    System.out.println("Saving to CSV");
                    //filename = enterFileName(); //enter name here
                    // save(tree, OUTPUT_CSV_FILENAME);
                }
                break;

                default:
                {  //User choice: Exit
                    System.out.println("Goodbye!");                    
                }
            }            
        }
        sc.close();        
    }//end mainMenu
    
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
         inObj = (DSAGraph)objStrm.readObject();//Deserialize. Note the cast is needed          
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
EXPORT: lineNum (integer)
ASSERTION: Imports a file name and counts the lines in it then returns the number
************************************************************/
public static int numOfLines(String filename)
{
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum = 0;
        
        try
        {
            fileStrm = new FileInputStream(filename);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;

            while (bufRdr.readLine() != null) 
            {
                lineNum++;
            }
            fileStrm.close();
        }
     
        catch (IOException e)
        {
            if (fileStrm != null)                      
            {
                try
                {
                    fileStrm.close();
                } 
                catch (IOException ex2){ }
                System.out.println("Error in file processing " + e.getMessage());
            }
        }
        return lineNum;
}//end numOfLines()


/************************************************************    
IMPORT: filename (String)
EXPORT: arrayOfStrings (String[] array)
ASSERTION: Imports a file name and writes it to a string array
************************************************************/
public static String[] readFile(String filename)
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;

        String line;

        String[] arrayOfStrings = new String[numOfLines(filename)]; //gets number of lines in file
        try
        {
            fileStrm = new FileInputStream(filename);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);
            
            line = bufRdr.readLine();
            while (line != null)
            {                
                arrayOfStrings = line.split(","); //adds read lines to array
                line = bufRdr.readLine();

            }
            fileStrm.close();
        }
     
        catch (IOException e)
        {
            if (fileStrm != null)                      
            {
                try
                {
                    fileStrm.close();
                } 
                catch (IOException ex2){ }
                System.out.println("Error in file processing " + e.getMessage());
            }
        }

        return arrayOfStrings;
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
            fileName = OUTPUT_CSV_FILENAME; //Sets filename to default
        }
        return fileName;
    }

    //PRINTING METHODS

    public static void printArray(int inArray[])
    {
    for(int i = 0; i < inArray.length; i++)
        {
            System.out.println(inArray[i]);
        }
    }

    //convert int[] to String[]
    public static String[] convertArrayS(int[] inArray)
    {
        String strArray[] = new String[inArray.length];

        for(int i = 0; i < inArray.length; i++)
        {
            strArray[i] = String.valueOf(inArray[i]);
        }
        return strArray;
    }

    //convert String[] to int[] 
    public static int[] convertArrayI(String[] inArray)
    {
        int outArray[] = new int[inArray.length];

        for(int i = 0; i < inArray.length; i++)
        {
            outArray[i] = Integer.parseInt(inArray[i]);
        }
        return outArray;
    }

}