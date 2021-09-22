/**
 *
 * @author Caio Marteli
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize variables
        DSAGraph graph = new DSAGraph();

        graph.addVertex("A", 56);
        graph.addVertex("B", 31);
        graph.addVertex("C", 68);
        graph.addVertex("D", 0);

        graph.addEdge("B", "C"); //adds 2 edges
        
        try {          

            System.out.println("TESTING IF TARGET B HAS VERTEX EXPECTED: EXPECTED: |TRUE|\nreturned>>" + graph.hasVertex("B"));            
            System.out.println("TESTING IF A & B ARE ADJACENT - EXPECTED: |FALSE|\nreturned>>"+ graph.isAdjacent("A","B"));
            System.out.println("TESTING IF B & C ARE ADJACENT - EXPECTED: |TRUE|\nreturned>>"+ graph.isAdjacent("B","C"));
            
            //System.out.println("Testing Display Method:");
            graph.displayAsList();

            //System.out.println("Testing Display Method:");
            //graph.DFS(2);
            
        } catch (Exception e) {
            //handles exceptions
            System.out.println(e.getMessage());
        }
        // graph.getVertex("B");

        //System.out.println(graph.getVertexCount());
        // graph.addEdge(a, b);
        // graph.addEdge(c, d);


        //graph.addVertex("A");

        //graph.hasVertex("B");
     
        //FileReader.menu(graph);

    }//end main
}
