/**
 * gameofcatz.java
 *
 * Main class Game of Cats, handles command line parameters
 * and catches any unhandled exceptions that may have fallen through the cracks.
 * 2021/October DSA Assignment
 * @author Caio Marteli (19598552)
 */
public class gameofcatz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try
        {
            UserInterface ui = new UserInterface();

            if(args.length < 1) //if no arguments
            {
                System.out.println("Game of Catz\nPlease enter the correct parameters\n-i : interactive testing environment\n-s : simulation mode (usage: gameofcatz –s infile savefile )");
            }
            else if(args[0].equals("-i"))
            {
                System.out.println("interactive mode");
                ui.menu();
            }
            else if(args[0].equals("-s"))
            {
                System.out.println("simulation mode");
                if(args.length != 3) //checks for correct number of parameters
                {
                    throw new IllegalArgumentException("Incorrect number of Arguments for this mode.");
                }
                ui.simulation(args[1], args[2]); //Start sim mode
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
