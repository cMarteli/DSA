import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public void menu()
    {
        String prompt =
        "What would you like to do?\n [1]Read a file\n [2]Write a file\n [3]Edit\n [4]Display the tree\n [0]Exit\n";
        int userSelect = 5;
        Scanner sc = new Scanner(System.in);
        DSATree tree = new DSATree();
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
                    tree = loadFile();
                }
                break;

                case 2:  //User choice: Write a csv file
                {
                    //String filename = enterFileName(CSV_FILENAME); //enter name here
                    System.out.println("Saved as: "+ "filename.out");
                    //saveCsv(tree, OUTPUT_CSV_FILENAME);
                }
                break;

                case 3:
                {   //User choice: edit
                    treeOperations(tree);

                }
                break;

                case 4:
                {   //User choice: Display
                    //User choice: Display the list in order
                    // System.out.println("DISPLAY");
                    tree.traverseTree(tree.getRoot());
                    // System.out.println("Preorder:");
                    // tree.preorderTraverseTree(tree.getRoot());
                    // System.out.println("Postorder:");
                    // tree.postOrderTraverseTree(tree.getRoot());
                    // System.out.println("InOrder:");
                    // tree.inOrderTraverseTree(tree.getRoot());
                    try {
                    System.out.println("Tree depth: "+ tree.height());
                    System.out.println("Tree max: "+ tree.find(tree.max(tree.getRoot())));
                    System.out.println("Tree min: "+ tree.find(tree.min(tree.getRoot())));

                    } catch (NoSuchElementException ex) {
                        //Not found
                        System.out.println(ex.getMessage());
                    } catch (NullPointerException en) {
                    //Not found
                    System.out.println(en.getMessage());
                    }
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
    IMPORT: graph (DSAGraph)
    EXPORT: none
    ASSERTION: submenu gives user access to edge operations
    ************************************************************/
    public void treeOperations(DSATree T)
    {
        String prompt =
        "[1]Find\n[2]Add\n[3]Remove\n[4]Back to menu";
        int userSelect = 0;
        while(userSelect != 4)
        {
            do
            {
                System.out.println("Current root node: " + T.getRoot()); //prints edge count
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1: //Find
                {
                    try {
                        System.out.println(T.find(getUsrStr("Please enter label").toString()));
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println(e.getMessage());
                    }

                }
                break;

                case 2: //Add
                {
                    try {
                        T.insert(getUsrStr("Please enter label"), checkInteger("Please enter value"));
                        System.out.println("Added new node");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

                case 3: //Remove TODO
                {
                    try {
                        T.deleteNode(getUsrStr("Please enter label"), T.getRoot());
                        System.out.println("removed node");

                    } catch (Exception e) {
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
    public DSATree loadFile()
    {
        DSATree T = new DSATree();
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