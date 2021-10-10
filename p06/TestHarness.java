/**
 *
 * @author Caio Marteli
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            FileReader.menu();

        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }

    }

}
