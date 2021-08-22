import java.util.Scanner;

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
    public void mainMenu(Object list)
    {
        String prompt = "What would you like to do?\n [1]Read a serialized file\n [2]Display the list\n [3]Write a serialized file\n [4]Exit\n";
        String usrStr = " ";
        int userSelect = 0;
        Scanner sc = new Scanner(System.in);
        ContainerClass cc = new ContainerClass();
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
                    System.out.println("SAVE");
                    cc.save((ContainerClass)list,"testFile");
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

}
