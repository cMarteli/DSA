import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * DSAStack.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */

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
        "What would you like to do?\n [1]Read a serialized file\n [2]Read a text file\n [3]Display the graph\n [4]Write a serialized file\n [5]Exit\n";
        String usrStr = " ";
        //String data[];
        DSAGraph graph = new DSAGraph();
        int userSelect = 0;
        Scanner sc = new Scanner(System.in);
        while(userSelect != 5)
        {
            do
            {
                System.out.println(prompt);
                usrStr = sc.next();
                userSelect = Integer.valueOf(usrStr);
            }
            while(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != 4 && userSelect != 5);
                               

            //case statement to choose required method
            switch (userSelect)
            {
                case 1: 
                {   //User choice: Read a serialized file         
                    System.out.println("LOAD!");
                    // // //filename = enterFileName(); //enter name here
                    graph = FileReader.load(SERIAL_FILENAME);           
                }
                break;

                case 2:
                {  //User choice: Read from text file
                    
                    String filename = INPUT_FILENAME; //enter name here TODO: HARDCODED

                    //System.out.println("Reading text file" + INPUT_FILENAME + "...");
                    try 
                    {
                        //System.out.println(FileReader.numOfLines("in.txt"));
                        graph = FileReader.readFile(filename);
                        
                    } catch (IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                break;

                case 3: //User choice: [3] Display the graph
                {   
                   if(!graph.isEmpty())
                   { 
                        try 
                        {
                            System.out.println("Traversing Graph...");
                            graph.depthFirstSearch().show();

                            // System.out.println("Testing Edges:");
                            // graph.printEdges(); //debug method
                            
                        } catch (NoSuchElementException ex) {
                            //Not found
                            System.out.println(ex.getMessage());
                        }
                   }
                   else
                   {
                       System.out.println("Graph is empty");
                   }

                }
                break;

                case 4: 
                {   //User choice: Write a serialized file
                    System.out.println("SAVE");
                    FileReader.save(graph, SERIAL_FILENAME);

 
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

