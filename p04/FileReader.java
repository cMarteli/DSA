import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Caio Marteli 19598552
 */
public class FileReader
{

    public static void main(String args[])
    {
        DSALinkedList list = new DSALinkedList();

        //ADD SOME DATA
        /*
        list.insertLast("1");
        list.insertLast("2");
        list.insertFirst("3");
        list.insertFirst("4");
        list.insertFirst("5");
        list.insertLast("6");
        */

        menu(list);
    
    }//end main


    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public static void menu(DSALinkedList list)
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
   public static void save(DSALinkedList objToSave, String filename) 
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

   public static DSALinkedList load(String filename) throws IllegalArgumentException  
   {   
      FileInputStream fileStrm;
      ObjectInputStream objStrm; 
      DSALinkedList inObj = null;
      try
      {
         fileStrm = new FileInputStream(filename);//Underlying stream 
         objStrm = new ObjectInputStream(fileStrm);//Object serialization stream        
         inObj = (DSALinkedList)objStrm.readObject();//Deserialize. Note the cast is needed          
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


}
