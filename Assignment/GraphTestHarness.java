import java.util.Iterator;
/**
 *
 * @author Caio Marteli - September 2021
 * @author Caio Marteli - October 2021
 * GraphTestHarness Class
 */
// Marteli, C (2021) DSAPrac6 source code (Version 2.0) [Source code]. https://github.com/cMarteli/DSA
// previously submitted for DSAPrac6 Modified and improved October 2021 for gameofcatz.java
public class GraphTestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();

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
            DSAQueue q = new DSAQueue();
            if(!q.isEmpty())
            {
            System.out.println("# All routes Traversed:");
            Iterator<DSAQueue> itr = q.iterator();
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



            System.out.println("Testing Edges:");
            graph.printEdges(); //debug method

            System.out.println("TESTING IF TARGET Bear IS A VERTEX EXPECTED: EXPECTED: |TRUE|\nreturned>>" + graph.hasVertex("Bear"));
            System.out.println("TESTING IF TARGET Mongoose IS A VERTEX EXPECTED: EXPECTED: |TRUE|\nreturned>>" + graph.hasVertex("Mongoose"));
            System.out.println("TESTING IF Snake & Dog ARE ADJACENT - EXPECTED: |FALSE|\nreturned>>"+ graph.isAdjacent("Snake","Dog"));
            System.out.println("TESTING IF Rabbit & Elephant ARE ADJACENT - EXPECTED: |TRUE|\nreturned>>"+ graph.isAdjacent("Rabbit","Elephant"));
            System.out.println("TESTING IF Cat & Snake ARE ADJACENT - EXPECTED: |TRUE|\nreturned>>"+ graph.isAdjacent("Cat","Snake"));

            System.out.println("Displaying all vertices in list order:");
            graph.displayAsList();

        } catch (Exception ex) {
            //Not found
            System.out.println(ex.getMessage());
        }

    }

}
