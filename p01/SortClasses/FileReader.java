import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Caio Marteli
 */
public class FileReader {

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
        int lineNum;
        String line;

        String[] arrayOfStrings = new String[numOfLines(filename)]; //gets number of lines in file
        try
        {
            fileStrm = new FileInputStream(filename);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            lineNum = 0;
            line = bufRdr.readLine();
            while (line != null)
            {                
                arrayOfStrings[lineNum] = line; //adds read lines to array
                line = bufRdr.readLine();
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

        return arrayOfStrings;
    }//end readfile()
/************************************************************    
IMPORT: csvRow (String[])
EXPORT: none
ASSERTION: parses single csv row
************************************************************/

    public static void processLine(String csvRow) throws IllegalStateException
    {
        int id;
        String name;

        String[] tokens = csvRow.split(",");

        try 
        {
            id = Integer.parseInt(tokens[0]);
            name = tokens[1];

            System.out.println("ID: " + id  + "\n" + "Name: " + name);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Invalid Format");
        }
    }//end processLine()



/************************************************************    
IMPORT: csvRow (String[])
EXPORT: none
ASSERTION: parses single csv row
************************************************************/

    public static int processId(String csvRow) throws IllegalStateException
    {
        int id;

        String[] tokens = csvRow.split(",");

        try 
        {
            id = Integer.parseInt(tokens[0]);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Invalid Format");
        }
        return id;
    }//end processLine()

/************************************************************    
IMPORT: fileName (String), printString (String[])
EXPORT: none
ASSERTION: writes formatted array of Strings to file
************************************************************/ 

    public static void writeFile(String fileName, String[] printString)    {

        FileOutputStream fos = null;
        PrintWriter pw;
        try
        {
        fos = new FileOutputStream(fileName);
        pw = new PrintWriter(fos);

        for(int i = 0; i < printString.length; i++)
            {
                if(printString[i] != null)                   
                pw.println(printString[i]);
            }
        pw.close();          
        }       
        catch(IOException e)
        {
            if (fos != null) 
            {
                try 
                {
                    fos.close();
                }
                catch (IOException ex2) { } 
            }
            System.out.println("Error in writing file: " + e.getMessage());
        }   
    }//end writeFile

}
