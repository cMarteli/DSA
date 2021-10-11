/**
 * Main class Game of Cats
 * JAVA
 * 2021 DSA Assignment
 * @author Caio Marteli
 */
public class GameOfCatz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try 
        {
            UserInterface ui = new UserInterface();
            ui.menu();

        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }

    }

}
