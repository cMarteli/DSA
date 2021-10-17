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
        String end = " "; //init default end parameter
        boolean userDefault = false; //has the user changed the default parameters?
        DSALinkedList listOfRoutes = new DSALinkedList(); //list of all traversed routes
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
                {   //User choice: Asks to Read in a text file or serialized
                    graph = loadFile();
                }
                break;

                case 2:
                {  //User choice: Node operations; get total # nodes add or remove nodes etc...
                    System.out.println("Node operations");
                    nodeOperations(graph);
                }
                break;

                case 3: //User choice: Allows user to a add links between areas
                {
                    System.out.println("Edge operations");
                    edgeOperations(graph);

                }
                break;

                case 4:
                {   //User choice: Parameter Tweaks Sets an end point for cat
                    System.out.println("Set a default end point");
                    do
                    {
                        end = getUsrStr("End:");
                    }
                    while(!graph.hasVertex(end));
                    userDefault = true;

                }
                break;

                case 5:
                {   //User choice: Display all vertices in no particular order
                    System.out.println("All cages in the zoo:");
                    graph.displayAsList();
                }
                break;

                case 6:
                {   //User choice: DISPLAY WORLD - Displays all links in the world
                    System.out.println("Displaying world");
                    graph.printEdges();
                }
                break;

                case 7:
                {   //User choice: Generate routes
                    System.out.println("Generate routes");

                    int numOfSims = checkInteger("How many simulations to run?");

                    for(int i = 0; i < numOfSims; i++)
                    {
                        generateRoutes(graph, listOfRoutes, userDefault, end);
                    }

                }
                break;

                case 8:
                {   //User choice: Displays all routes created in simulation so far
                    displayRoutes(listOfRoutes);
                }
                break;

                case 9:
                {   //Save network SAVES SERIALIAZABLE
                    System.out.println("Saving network");
                    String filename = checkFileName(".out"); //saves as .out
                    FileReader.save(graph, filename);
                    System.out.println("Saved as " + filename);
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
    ASSERTION: submenu gives user access to node operations
    ************************************************************/
    public void nodeOperations(DSAGraph graph)
    {
        String prompt =
        "[1]Find\n[2]Insert\n[3]Delete\n[4]Update\n[5]Back to menu";
        int userSelect = 0;
        while(userSelect != 5)
        {
            do
            {
                System.out.println("Current vertex count: " + graph.getVertexCount()); //prints vertex count
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 5);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1: //Find
                {
                    String nodeTOfind = getUsrStr("Enter label to locate node by:");
                    if(graph.hasVertex(nodeTOfind))
                    {
                        System.out.println("|" + nodeTOfind + "| is present");
                    }
                    else
                    {
                        System.out.println("|"  + nodeTOfind + "| not found");
                    }
                }
                break;

                case 2: //Insert - allows user to add in a node
                {
                    try {
                        graph.addVertex(getUsrStr("Enter label:"), getUsrStr("Enter Code:"));
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }

                }
                break;

                case 3: //Delete a node
                {
                    try {
                        graph.removeVertex(getUsrStr("Enter label:"));
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }

                }
                break;

                case 4: //Update - allows user to replace label information on a node
                {
                    try {
                        graph.changeVxLabel(getUsrStr("Enter label to Change:"), getUsrStr("Enter new label:"));
                    } catch (IllegalArgumentException e)
                    {
                        //handles exception
                        System.out.println(e.getMessage() + "\nNothing was changed");
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
    IMPORT: graph (DSAGraph)
    EXPORT: none
    ASSERTION: submenu gives user access to edge operations
    ************************************************************/
    public void edgeOperations(DSAGraph graph)
    {
        String prompt =
        "[1]Find\n[2]Add\n[3]Remove\n[4]Back to menu";
        int userSelect = 0;
        while(userSelect != 4)
        {
            do
            {
                System.out.println("Current edge count: " + graph.getEdgeCount()); //prints edge count
                userSelect = checkInteger(prompt);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4);


            //case statement to choose required method
            switch (userSelect)
            {
                case 1: //Find edge
                {
                    if(graph.isAdjacent(getUsrStr("Please enter first vertex"), getUsrStr("Please enter second vertex")))
                    {
                        System.out.println("Edge is present");
                    }
                    else
                    {
                        System.out.println("No edge found");
                    }

                }
                break;

                case 2: //Adds Edge returns false if edge already exists and informs user
                {
                    try {
                        if(graph.addEdge(getUsrStr("Please enter first vertex"), getUsrStr("Please enter second vertex")))
                        {
                            System.out.println("Added new edge");
                        }
                        else
                        {
                            System.out.println("Edge already exists");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

                case 3: //Removes an edge
                {
                    try {
                        if(graph.removeEdge(getUsrStr("Please enter first vertex"), getUsrStr("Please enter second vertex")))
                        {
                            System.out.println("Removed edge");
                        }
                        else
                        {
                            System.out.println("Edge does not exist");
                        }
                    } catch (IllegalArgumentException e) {
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
    IMPORT: infile (String), savefile (String)
    EXPORT: none
    ASSERTION: runs when program is booted into simulation mode
    ************************************************************/
    public void simulation(String infile, String saveFile)
    {
        DSAGraph graph = new DSAGraph();
        DSALinkedList listOfRoutes = new DSALinkedList(); //list of all traversed routes
        graph = FileReader.readFile(infile + ".txt"); //reads in file assumes it's a .txt
        int numOfSims = checkInteger("How many simulations to run?"); //get amount of sims

        for(int i = 0; i < numOfSims; i++)
        {
            generateRoutes(graph, listOfRoutes, false, " "); //generates routes setting default to false
        }
        displayRoutes(listOfRoutes); //displays output to user

        System.out.println("Saving to file: " + saveFile+".txt");
        FileReader.saveOutput(saveFile+".txt", listOfRoutes); //saves as .txt
    }


    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Validator Method. Gets user integer and repeats until it's a valid input
    ************************************************************/
    public DSAGraph loadFile()
    {
        DSAGraph g = new DSAGraph();
        int temp = checkInteger("Read a [1]Text file or [2]Serialized file?");
        if(temp == 1) //[1]Text file
        {
            String filename = checkFileName(".txt"); //gets filename from user assumes <.txt>
            try
            {
                g = FileReader.readFile(filename);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else if(temp == 2) //[2]Serialized file
        {
            String filename = checkFileName(".out"); //gets filename from user assumes <.out>
            try
            {
                g = FileReader.load(filename);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Back to menu...");
        }
        return g;
    }

    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Validator Method. Gets user integer and repeats until it's a valid input
    ************************************************************/
    public void generateRoutes(DSAGraph g, DSALinkedList list, boolean udefault, String end)
    {
        try
        {
            if(!udefault) //if there's not end destination cat will just traverse every point
            {
                list.insertLast(g.depthFirstSearch(getUsrStr("Enter label to serve as starting point:"))); //Inserts queue into list
            }
            else
            {
                list.insertLast(g.breadthFirstSearch(getUsrStr("Enter label to serve as starting point:"),end));  //Inserts into list
            }

        }
        catch (NoSuchElementException ex)
        {
            //Not found
            System.out.println(ex.getMessage());
        }
    }

    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Validator Method. Gets user integer and repeats until it's a valid input
    ************************************************************/
    public void displayRoutes(DSALinkedList list)
    {
        if(!list.isEmpty())
        {
            System.out.println("# All routes Traversed:");
            Iterator<DSAQueue> itr = list.iterator();
            int counter = 0;
            while(itr.hasNext())
            {
                counter ++;
                System.out.println("\n# Route number: [" + counter + "]");
                itr.next().show();
            }
        }
        else
        {
            System.out.println("# Route list is empty. Add some more!");
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