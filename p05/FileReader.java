import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Caio Marteli 19598552
 */
public class FileReader {

    public static final String DEFAULT_FILENAME = "test.csv";

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
