import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * DSAStack.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
@SuppressWarnings("resource")
 public class UserInterface
 {
    public static final String SERIAL_FILENAME = "serial.txt", INPUT_FILENAME = "input.txt";

    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Gets user input and performs the associated task while handling invalid inputs
    ************************************************************/
    public void menu()
    {
        String prompt =
        "What would you like to do?\n[1]Load input file\n[2]Node operations\n[3]Edge operations\n[4]Parameter Tweaks\n" +
            "[5]Display Graph\n[6]Display World\n[7]Generate routes\n[8]Display routes\n[9]Save network\n[0]Exit";
        DSAGraph graph = new DSAGraph();
        int userSelect = 10;
        while(userSelect != 0)
        {
            do
            {
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 5 &&
            userSelect != 6 && userSelect != 7 && userSelect != 8 && userSelect != 9 && userSelect != 0);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1:
                {   //User choice: Read in a text file
                    String filename = checkFileName(); //gets filename from user
                    graph = FileReader.readFile(filename);
                }
                break;

                case 2:
                {  //TODO User choice: Node operations
                    System.out.println("Node operations");
                    nodeOperations(graph);
                    //get total # nodes add or remove nodes etc...
                }
                break;

                case 3: //TODO User choice: Edge operations
                {
                    System.out.println("Edge operations");
                    edgeOperations(graph);

                }
                break;

                case 4:
                {   //TODO User choice: Parameter tweaks
                    System.out.println("Parameter tweaks");

                }
                break;

                case 5:
                {   //TODO User choice: Display graph
                    graph.displayAsList();
                }
                break;

                case 6:
                {   //TODO User choice: Display world
                    System.out.println("Display world");
                    System.out.println("Traversing Graph...");
                    try
                    {
                        graph.depthFirstSearch().show();

                    }
                    catch (NoSuchElementException ex)
                    {
                        //Not found
                        System.out.println(ex.getMessage());
                    }


                }
                break;

                case 7:
                {   //TODO User choice: Generate routes
                    System.out.println("Generate routes");

                }
                break;

                case 8:
                {   //TODO User choice: Display routes
                    System.out.println("Display routes");

                }
                break;

                case 9:
                {   //TODO User choice: Save network SAVES SERIALIAZABLE
                    System.out.println("Save network");
                    FileReader.save(graph, SERIAL_FILENAME);

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
    IMPORT: infile (String), savefile (String)
    EXPORT: none
    ASSERTION: runs when program is booted into simulation mode
    ************************************************************/
    public void simulation(String infile, String saveFile)
    {
        DSAGraph graph = new DSAGraph();
        graph = FileReader.readFile(infile);

        System.out.println("Traversing Graph...");
        graph.depthFirstSearch().show();


        System.out.println("Saving to file: " + saveFile+".out");
        FileReader.save(graph, saveFile+".out");
    }

    /************************************************************
    IMPORT: graph (DSAGraph)
    EXPORT: none
    ASSERTION: submenu gives user access to node operations
    ************************************************************/
    public void nodeOperations(DSAGraph graph)
    {
        System.out.println("Current vertex count: " + graph.getVertexCount());

        String prompt =
        "[1]Find\n[2]Insert\n[3]Delete\n[4]Update\n[5]Back to menu";
        int userSelect = 0;
        while(userSelect != 5)
        {
            do
            {
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 5);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1: //Find
                {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter label to locate node by:");
                    String userLabel = sc.next();
                    if(graph.hasVertex(userLabel))
                    {
                        System.out.println("FOUND");
                    }
                }
                break;

                case 2: //Insert TODO allow EU to add in weight
                {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter label:");
                    String inLabel = sc.next();
                    graph.addVertex(inLabel);
                }
                break;

                case 3: //TODO Delete
                {

                }
                break;

                case 4: //TODO Update
                {
                    graph.displayAsList();
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
    IMPORT: graph (DSAGraph)
    EXPORT: none
    ASSERTION: submenu gives user access to edge operations
    ************************************************************/
    public void edgeOperations(DSAGraph graph)
    {
        String prompt =
        "[1]Find\n[2]Add\n[3]Remove\n[4]Update\n[5]Back to menu";
        int userSelect = 0;
        while(userSelect != 5)
        {
            do
            {
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 5);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1: //Find
                {

                }
                break;

                case 2: //TODO Add
                {

                }
                break;

                case 3: //TODO Remove
                {

                }
                break;

                case 4: //TODO Update
                {
                    System.out.println("Testing Edges:");
                    graph.printEdges(); //debug method
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
    ASSERTION: Lets user enter the file name
    ************************************************************/
    public String checkFileName()
    {
        Scanner sc = new Scanner(System.in);
        String prompt = "Please enter a file name:", filename = "";
        int ans = 0;

        System.out.println(prompt);
        filename = sc.next() + ".txt";
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
            return checkFileName();
        }
    }

 }