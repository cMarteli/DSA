import java.io.Serializable;
/**
 *
 * @author Caio Marteli
 * Adjecency List Graph
 */
public class DSAGraph implements Serializable
{
	public DSALinkedList vertices;

	/************************************************************
	CONSTRUCTOR:
	IMPORT: none
	EXPORT: address of new DSA Graph
	ASSERTION: creates empty linked list
	************************************************************/
	public DSAGraph()
	{
		vertices = new DSALinkedList();
	}

	/************************************************************
	MUTATORS
	************************************************************/	

	/************************************************************
	IMPORT: label (String), value (Object)
	EXPORT: none
	ASSERTION: adds new vertex to with label and value
	************************************************************/
	public void addVertex(String label, Object value)
	{
		DSAGraphVertex v = new DSAGraphVertex(label, value);
		vertices.insertLast(v); //inserts into vertices list at end
	}

	/************************************************************
	IMPORT: label (String), value (Object)
	EXPORT: none
	ASSERTION: TODO: uses labels to add edge between vertices
	************************************************************/
	public void addEdge(String label1, String label2)
	{

	}
	//TODO: STUBBED
	public boolean hasVertex(String label)
	{
		return false;
	}
	//TODO: STUBBED
	public int getVertexCount()
	{
		return 0;
	}
	//TODO: STUBBED
	public int getEdgeCount()
	{
		return 0;
	} 
	//TODO: STUBBED
	public DSAGraphVertex getVertex(String label) 
	{
		return null; 
	} 
	//TODO: STUBBED exports vertex list? 
	public DSAGraphVertex getAdjacent(String label)
	{
		return null;		
	}
	public boolean isAdjacent(String label1, String label2)
	{
		return false;
	}
	//TODO: write code for this method
	public void displayAsList()
	{
		System.out.println("STUB");

	}
	//TODO: write code for this method
	public void displayAsMatrix()
	{
		System.out.println("STUB");
	}


	/************************************************************
	PRIVATE INNER CLASS
	************************************************************/
	private class DSAGraphVertex
	{
		String label;
		Object value;
		DSALinkedList links;
		boolean visited; //has someone visited node? true or false

		/************************************************************
		Constructor:
		IMPORT: none
		EXPORT: address of new DSAGraphVertex object
		ASSERTION: Sets label and value from parameters; visited = false is default
		************************************************************/ 
		public DSAGraphVertex(String inLabel, Object inValue)
		{
			label = inLabel;
			value = inValue;
			links = new DSALinkedList();
			visited = false;		
		}
		/**************************************************
		ACCESSORS
		**************************************************/
		public String getLabel()
		{
			return label;
		}

		public Object getValue()
		{
			return value;
		}
		//should return vertices list
		public DSALinkedList getAdjacent()
		{
			return links;
		}

		public boolean getVisited()
		{
			return visited;
		} 
		/**************************************************
		MUTATORS
		**************************************************/
		public void addEdge(DSAGraphVertex inVertex)
		{
			links.insertLast(inVertex); //inserts at the end of links
		} 
		public void setVisited()
		{
			visited = true;
		}
		//for searching (later)
		public void clearVisited()
		{
			visited = false;
		}
		//Return formatted string
		public String toString()
		{
			return ("Label: " + label + "Is visited: " + visited + "\nValue info: " + value.toString());
		}

	}	

}
