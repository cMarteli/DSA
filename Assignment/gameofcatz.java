/**
 * gameofcatz.java
 *
 * Main class Game of Cats, handles command line parameters
 * and catches any unhandled exceptions that may have fallen through.
 * 2021/October DSA Assignment
 * @author Caio Marteli (19598552)
 */
public class gameofcatz {
    public static final String SPLASH = "******************\n* GAME OF CATZ	*\n******************\n";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try
        {
            UserInterface ui = new UserInterface();

            if(args.length < 1) //if no arguments
            {
                System.out.println(SPLASH + "Please enter the correct parameters:\n-i : interactive testing environment\n-s : simulation mode (usage: gameofcatz -s infile savefile) NOTE: don't type <.txt>");

                System.out.println("\nA very hungry feline wants it all!\nThe cat will wander around attempt to eat steal food from every animal in the zoo!\n" +
                "The user may select the start point and end point and the cat will steal from every location then finish at the end point once he's done! \n\nWritten by: C Marteli");
            }
            else if(args[0].equals("-i"))
            {
                System.out.println(SPLASH);
                System.out.println(">>Interactive mode.");
                ui.menu();
            }
            else if(args[0].equals("-s"))
            {
                System.out.println(">>Simulation mode.");
                if(args.length != 3) //checks for correct number of parameters
                {
                    throw new IllegalArgumentException("Incorrect number of Arguments for this mode.");
                }
                System.out.println(SPLASH);
                ui.simulation(args[1], args[2]); //Start sim mode
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
