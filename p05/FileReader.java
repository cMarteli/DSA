import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Caio Marteli 19598552
 */
public class FileReader {

    public static final String DEFAULT_FILENAME = "test.csv";


    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public static void menu(DSATree list)
    {
        String prompt = "What would you like to do?\n [1]Read a serialized file\n [2]Display the list\n [3]Write a serialized file\n [4]Exit\n";
        String usrStr = " ";
        int userSelect = 0;
        Scanner sc = new Scanner(System.in);
        while(userSelect != 4)
        {
            do
            {
                System.out.println(prompt);
                usrStr = sc.next();
                userSelect = Integer.valueOf(usrStr);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4);
                               

            //case statement to choose required method
            switch (userSelect)
            {
                case 1: 
                {   //User choice: Read a serialized file         
                    System.out.println("LOAD!");
                    //add get file name method !!HARDCODED!!
                    list = load("output1.txt");                 
                }
                break;

                case 2: 
                {   //User choice: Display the list
                    System.out.println("DISPLAY");
                    list.show();

                }
                break;

                case 3: 
                {   //User choice: Write a serialized file
                    System.out.println("SAVE");
                    save(list, "output1.txt");

 
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
   public static void save(DSATree objToSave, String filename) 
   {   
      FileOutputStream fileStrm; 
      ObjectOutputStream objStrm;

      try
      { 
         fileStrm = new FileOutputStream(filename);   //Underlying stream 
         objStrm = new ObjectOutputStream(fileStrm);    //Object serialization stream 
         objStrm.writeObject(objToSave);    //Serialize and save to filename, This will also save the ContainerClass contained Location object
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

   public static DSATree load(String filename) throws IllegalArgumentException  
   {   
      FileInputStream fileStrm;
      ObjectInputStream objStrm; 
      DSATree inObj = null;
      try
      {
         fileStrm = new FileInputStream(filename);//Underlying stream 
         objStrm = new ObjectInputStream(fileStrm);//Object serialization stream        
         inObj = (DSATree)objStrm.readObject();//Deserialize. Note the cast is needed          
         objStrm.close();//Clean up    
      }
      catch (ClassNotFoundException e) 
      { 
         System.out.println("Class ContainerClass not found" + e); 
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
   
        }
        else
        {
            fileName = DEFAULT_FILENAME; //Sets filename to default
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