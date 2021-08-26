import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.lang.Object;


/**
 *
 * @author Caio Marteli 19598552
 */
public class FileReader
{
    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public void mainMenu()
    {
        String prompt = "What would you like to do?\n [1]Read a serialized file\n [2]Display the list\n [3]Write a serialized file\n [4]Exit\n";
        String usrStr = " ";
        int userSelect = 0;
        Scanner sc = new Scanner(System.in);
        DSAStack<Double> nums;
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
                }
                break;

                case 2: 
                {   //User choice: Display the list
                    System.out.println("DISPLAY");
                }
                break;

                case 3: 
                {   //User choice: Write a serialized file
                    nums = new DSAStack<Double>();
                    System.out.println("Checking if stack is empty, expected: |TRUE| \nResult: "+ nums.isEmpty());
                    //nums.pop(); //Should throw exception
                    System.out.println("Push 12.0");        
                    nums.push(12.0); 
                    System.out.println("Push 8.0");
                    nums.push(8.0);
                    System.out.println("Push 10.0");
                    nums.push(10.0);
                    System.out.println("Real output:");
                    nums.show();
                    System.out.println("SAVE");
                    save(nums,"testFile");
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
   public void save(DSAStack<Double> objToSave, String filename) 
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
         throw new IllegalArgumentException("Unable to save object to file"); 
      }         
   }

   /************************************************************
    IMPORT: filename(String)
    EXPORT: inObj(ContainerClass) - serialized file
    ASSERTION: Gets filename and performs the associated task while handling invalid inputs
    ************************************************************/
    /*
   public DSALinkedList<T> load(String filename) throws IllegalArgumentException  
   {   
      FileInputStream fileStrm;
      ObjectInputStream<T> objStrm; 
      DSALinkedList<T> inObj = null;
      try
      {
         fileStrm = new FileInputStream(filename);//Underlying stream 
         objStrm = new ObjectInputStream(fileStrm);//Object serialization stream   
        
         inObj = objStrm.readObject();//Deserialize. Note the cast is needed 
          
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
      return inObj;   }

      */


}
