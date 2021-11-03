import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * UserInterface.java
 * Contains menus and user input handling methods
 * @author Caio Marteli (19598552)
 */
// Marteli, C (2021) OOPD source code (Version 1.0) [Source code]. https://github.com/cMarteli/
// Some methods previously submitted for OOPD final assignment Modified and improved October 2021 for gameofcatz.java
@SuppressWarnings("unchecked")
 public class UserInterface
 {
    public static final String SERIAL_FILENAME = "serial.txt", CSV_FILENAME = "tree.csv";
    public static final int MAX_HEAP_SIZE = 200; //TODO: Hardcoded limit;
    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public void menu()
    {
        String prompt =
        "What would you like to do?\n [1]Read a file\n [2]Write a file\n [3]Edit\n [4]Display\n [0]Exit\n";
        int userSelect = 5;
        Scanner sc = new Scanner(System.in);
        DSAMaxHeap heap = new DSAMaxHeap(MAX_HEAP_SIZE);
        while(userSelect != 0)
        {
            do
            {
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 0);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1:
                {   //User choice: Asks to Read in a text file or serialized
                    heap = loadFile();
                }
                break;

                case 2:  //User choice: Write a csv file TODO
                {
                    //String filename = enterFileName(CSV_FILENAME); //enter name here
                    System.out.println("STUB");
                    //saveCsv(tree, OUTPUT_CSV_FILENAME);
                }
                break;

                case 3:
                {   //User choice: edit
                    heapOperations(heap);

                }
                break;

                case 4:
                {   //User choice: Display

                    heap.print();
                }
                break;

                default:
                {  //User choice: Exit
                    System.out.println("Goodbye!");
                }
            }
        }
    }//end mainMenu

    /************************************************************
    IMPORT: T (DSATree)
    EXPORT: none
    ASSERTION: submenu gives user access to tree node operations
    ************************************************************/
    public void heapOperations(DSAMaxHeap T)
    {
        String prompt =
        "[1]Add\n[2]Remove\n[3]Back to menu";
        int userSelect = 0;
        while(userSelect != 3)
        {
            do
            {
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1: //Add
                {
                    try {
                        T.insert(checkInteger("Please enter data"));
                        System.out.println("Added new node");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

                case 2: //Remove
                {
                    try
                    {
                        System.out.println("Removed from heap: " + T.extractMax());
                    } catch (IllegalArgumentException e) {
                        //If data does not exist
                        System.out.println(e.getMessage());
                    }
                }
                break;

                default: //User choice: Exit
                {
                    System.out.println("...Returning");
                }
            }
        }
    }


    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Validator Method. Gets user integer and repeats until it's a valid input
    ************************************************************/
    public DSAMaxHeap loadFile()
    {
        DSAMaxHeap T = new DSAMaxHeap(MAX_HEAP_SIZE);
        int temp = checkInteger("Read a [1]Text file or [2]Serialized file?");
        if(temp == 1) //[1]Text file
        {
            String filename = checkFileName(".txt"); //gets filename from user assumes <.txt>
            try
            {
                T = FileReader.readFile(filename);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else if(temp == 2) //[2]Serialized file
        {
            String filename = checkFileName(".out"); //gets filename from user assumes <.out>
            try
            {
                T = FileReader.load(filename);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Back to menu...");
        }
        return T;
    }



    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Validator Method. Gets user integer and repeats until it's a valid input
    ************************************************************/
    public int checkInteger(String prompt)
    {
        Scanner sc;
        int userInt = 0;
        String error = "(Invalid Number)\n";
        String outStr = prompt;
        boolean isValid = false;

        while (isValid == false)
        {
            try
            {
                System.out.println(outStr);
                sc = new Scanner(System.in);
                outStr = error + prompt;
                userInt = sc.nextInt();
                isValid = true;
            }
            catch(InputMismatchException e)
            {
                System.out.print(error);
                sc = new Scanner(System.in);
                userInt = 0;
                outStr = prompt;
                isValid = false;
            }
        }

        return userInt;
    }

    /************************************************************
    IMPORT: none
    EXPORT: filename (String)
    ASSERTION: Prompts user for a string
    ************************************************************/
    public String getUsrStr(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String usrStr = sc.next();
        return usrStr;
    }

    /************************************************************
    IMPORT: ext (String)
    EXPORT: filename (String)
    ASSERTION: Lets user enter the file name
    ************************************************************/
    public String checkFileName(String ext)
    {
        Scanner sc = new Scanner(System.in);
        String prompt = "Please enter a file name:", filename = "";
        int ans = 0;

        System.out.println(prompt);
        filename = sc.next() + ext;
        prompt = "File name: <" + filename + ">\nIs this correct? [1]Confirm [2]Cancel\n";
        do
        {
            ans = checkInteger(prompt);
        }
        while(ans != 1 && ans != 2);

        if(ans == 1)
        {
            return filename;
        }
        else
        {
            return checkFileName(ext);
        }
    }

 }