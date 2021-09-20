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
        graph.addVertex("D");

        graph.addEdge("B", "C"); //this method is making it loop
        
        try {
            graph.getVertex("D");
            
        } catch (Exception e) {
            //TODO: handle exception
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
