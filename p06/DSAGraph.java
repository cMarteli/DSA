import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Caio Marteli
 * Adjecency List Graph
 */
@SuppressWarnings("unchecked")
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
	ASSERTION: adds new vertex to with label only and sets value to null
	************************************************************/
	public void addVertex(String label)
	{
		DSAGraphVertex v = new DSAGraphVertex(label,null);		
		vertices.insertLast(v); //inserts into vertices list at end
	}

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
	IMPORT: label1 (String), label2 (String)
	EXPORT: none
	ASSERTION: Adds edge between 2 parameter nodes
	************************************************************/

	public void addEdge(String label1, String label2)
	{
		DSAGraphVertex vx1 = getVertex(label1), vx2 = getVertex(label2);
		vx1.addEdge(vx2);
		vx2.addEdge(vx1);
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: boolean
	ASSERTION: check if vertices list has the node from label
	************************************************************/
	public boolean hasVertex(String label)
	{
		boolean sucess = false;
		try {
			getVertex(label);
			sucess = true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		return sucess;
	}
	/************************************************************
	IMPORT: none
	EXPORT: count (integer)
	ASSERTION: iterates through vertices list and returns count
	************************************************************/
	
	public int getVertexCount()
	{
		int count = 0;
		Iterator<DSAGraphVertex> itr = vertices.iterator();
		while(itr.hasNext())
		{
			count++;
			itr.next();
		}
		return count;
	}
	//TODO: STUB need to traverse graph and increment a counter every time an edge is found (check for dupes)
	public int getEdgeCount()
	{
		return 0;
	}
	/************************************************************
	IMPORT: label (String)
	EXPORT: target (DSAGraphVertex)
	ASSERTION: iterates through vertices list w/ a label and returns target if found; if not throws exception
	************************************************************/
	public DSAGraphVertex getVertexByValue(String label) 
	{
		DSAGraphVertex temp, target = null;
		Iterator<DSAGraphVertex> itr = vertices.iterator();	
		if(vertices.isEmpty()) // case: list is empty
		{
			System.out.println("Vertices list is empty.");
		}
		else //searches for target
		{
			while(itr.hasNext()) //iterates until target is found
			{				
				temp = itr.next();
				if(temp.getValue().equals(label))
				{
					target = temp;
				}
			}
		}
		if(target == null) // case: not found
		{
			throw new NoSuchElementException("Value |" + label + "| not found");
		}
		//System.out.println("Value: " + target.getValue() + "\nLabel: " + target.getLabel()); // debug		
		
		return target;		
	} 
	/************************************************************
	IMPORT: label (String)
	EXPORT: target (DSAGraphVertex)
	ASSERTION: iterates through vertices list w/ a label and returns target if found; if not throws exception
	************************************************************/
	public DSAGraphVertex getVertex(String label) 
	{
		DSAGraphVertex temp, target = null;
		Iterator<DSAGraphVertex> itr = vertices.iterator();		
		if(vertices.isEmpty()) // case: list is empty
		{
			System.out.println("Vertices list is empty.");
		}
		else //searches for target
		{
			while(itr.hasNext()) //iterates until target is found
			{				
				temp = itr.next();
				if(temp.getLabel().equals(label))
				{
					target = temp;
				}
			}
		}
		if(target == null) // case: not found
		{
			throw new NoSuchElementException("Label |" + label + "| not found");
		}
		//System.out.println("Label: " + target.getLabel() + "\nValue: " + target.getValue()); // debug		
		
		return target;		
	} 

	/************************************************************
	IMPORT: label (String)
	EXPORT: getAdjacent (DSALinkedList)
	ASSERTION: returns the adjecency list from node w/ label
	************************************************************/
	public DSALinkedList getAdjacent(String label)
	{
		DSAGraphVertex vx = getVertex(label);
		return vx.getAdjacent();
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: bool (DSALinkedList)
	ASSERTION: checks if two nodes are adjacent
	************************************************************/
	public boolean isAdjacent(String label1, String label2)
	{
		DSAGraphVertex temp, vx1 = getVertex(label1);
		DSALinkedList adjList = vx1.getAdjacent();
		Iterator<DSAGraphVertex> itr = adjList.iterator(); // - Maybe needs to check instance?
		boolean found = false;	
		if(adjList.isEmpty()) // case: list is empty
		{
			System.out.println("Adjacency list of "+ label1
			 +" is empty.");
		}
		else //searches for target
		{
			while(itr.hasNext()) //iterates until target is found
			{				
				temp = itr.next();
				if(temp.getLabel().equals(label2))
				{
					found = true;
				}
			}
		}
			
		return found;
	}
	//TODO: add more to this method
	public void displayAsList()
	{
		System.out.println("Printing all vertices");
		vertices.show(); //only works currently if no values are null

	}
	//TODO: write code for this method
	public void displayAsMatrix()
	{
		System.out.println("STUB");
	}
	/************************************************************
	IMPORT: label (String)
	EXPORT: bool (DSALinkedList)
	ASSERTION: DEPTH FIRST SEARCH TODO: complete method
	************************************************************/
	void DFSUtil(DSAGraphVertex vx, DSAStack visited)
	{
		// Mark the current node as visited and print it
		vx.setVisited();
		System.out.print("Pushed: " + vx.getLabel() + "\n");
		visited.push(vx);

		// Recur for all the vertices adjacent to this
		// vertex
		Iterator<DSAGraphVertex> itr = vx.getAdjacent().iterator();
		while (itr.hasNext()) 
		{
			if(!vx.getVisited())
			{
				vx = itr.next();
				DFSUtil(vx, visited);
			}
			else
			{
				visited.pop();
			}
		}
	}

	// The function to do DFS traversal.
	// It uses recursive, v is the chosen root
	// DFSUtil() TODO: complete method
	void DFS()
	{
		
		DSAGraphVertex vx = (DSAGraphVertex)vertices.peekFirst();
		DSAStack visited = new DSAStack();

		// Call the recursive helper 
		// function to print DFS
		// traversal
		DFSUtil(vx, visited);
	}

	/************************************************************
	PRIVATE INNER CLASS
	************************************************************/
	private class DSAGraphVertex
	{
		private String label;
		private Object value;
		private DSALinkedList links;
		private boolean visited; //has someone visited node? true or false

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
			return ("Label: |" + label + "| Visited? |" + visited + "| Value: " + value.toString());
		}

	}	

}
