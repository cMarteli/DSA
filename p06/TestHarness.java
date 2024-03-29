/**
 *
 * @author Caio Marteli
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        graph.addVertex("Elephant");
        graph.addVertex("Rabbit");
        graph.addVertex("Dog");
        graph.addVertex("Ant");
        graph.addVertex("Mongoose");
        graph.addVertex("Narwhal");
        graph.addVertex("Snake");
        graph.addVertex("Cat");
        graph.addVertex("Bear");

        graph.addEdge("Elephant", "Rabbit");
        graph.addEdge("Elephant", "Bear");

        graph.addEdge("Rabbit", "Bear");
        graph.addEdge("Rabbit", "Dog");
        graph.addEdge("Rabbit", "Snake");
        graph.addEdge("Rabbit", "Cat");

        graph.addEdge("Dog", "Ant");
        graph.addEdge("Dog", "Narwhal");

        graph.addEdge("Snake", "Rabbit");
        graph.addEdge("Snake", "Cat");


        try
        {
            System.out.println("Traversing Graph...");
            graph.depthFirstSearch().show();

            System.out.println("Testing Edges:");
            graph.printEdges(); //debug method

            System.out.println("TESTING IF TARGET Bear HAS VERTEX EXPECTED: EXPECTED: |TRUE|\nreturned>>" + graph.hasVertex("Bear"));
            System.out.println("TESTING IF TARGET Mongoose HAS VERTEX EXPECTED: EXPECTED: |FALSE|\nreturned>>" + graph.hasVertex("Mongoose"));
            System.out.println("TESTING IF Snake & Dog ARE ADJACENT - EXPECTED: |FALSE|\nreturned>>"+ graph.isAdjacent("Snake","Dog"));
            System.out.println("TESTING IF Rabbit & Elephant ARE ADJACENT - EXPECTED: |TRUE|\nreturned>>"+ graph.isAdjacent("Rabbit","Elephant"));
            System.out.println("TESTING IF Cat & Snake ARE ADJACENT - EXPECTED: |TRUE|\nreturned>>"+ graph.isAdjacent("Cat","Snake"));

            System.out.println("Displaying all vertices in list order:");
            graph.displayAsList();

        } catch (NoSuchElementException ex) {
            //Not found
            System.out.println(ex.getMessage());
        }

    }

}
