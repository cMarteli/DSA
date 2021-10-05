import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.spi.DirStateFactory.Result;
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

	//DEBUG method, iterates through vertices list and prints all edges
	public void printEdges()
	{
		Iterator<DSAGraphVertex> itr = vertices.iterator();
		while(itr.hasNext())
		{			
			itr.next().printAdjacent();
		}
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
	IMPORT: none
	EXPORT: count (integer)
	ASSERTION: iterates through vertices list and returns count
	************************************************************/
	
	public void clear()
	{
		Iterator<DSAGraphVertex> itr = vertices.iterator();
		while(itr.hasNext())
		{			
			itr.next().clearVisited();
		}
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: bool (DSALinkedList)
	ASSERTION: DEPTH FIRST SEARCH TODO: complete method
	************************************************************/
	public void DFSUtil(DSAGraphVertex vx, DSAStack visited)
	{
		if(vx != null){
		visited.push(vx);
		}
		Iterator<DSAGraphVertex> itr = vx.getAdjacent().iterator();
		// Recur for all the vertices adjacent to this
		// vertex
		 //while stack is not empty
		do{
			while (itr.hasNext() && !visited.isEmpty())		
			{
				vx = itr.next();				
				if(!vx.getVisited()) //if not visited traverse here
				{
					System.out.println(vx.toString()); //debug
					vx.setVisited(); //check later
					DFSUtil(vx, visited);
				}
			}
			try {
				visited.pop();
			} catch (Exception e) {
				//System.out.println(e.getMessage());
			}
			
				
		}while(!visited.isEmpty());
		
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: queue (DSAQueue)
	ASSERTION: Wrapper DEPTH FIRST SEARCH returns q of objs TODO: need to grab output instead of printing
	************************************************************/
	public void depthFirstSearch()
	{
		//String queue = " ";
		clear(); //sets all visited on all vertices == false
		DSAGraphVertex vx = (DSAGraphVertex)vertices.peekFirst(); //picks head of vertices list to start on
		DSAStack visited = new DSAStack();	//creates empty stack
		vx.setVisited(); // Marks vx visited == true
		System.out.println(vx);//start point
		//queue = vx.toString();

		
		DFSUtil(vx, visited); //begin recursion

		//return queue;
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

		public void printAdjacent()
		{
			System.out.println("Edges of: " + label);
			links.show();
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
			return("|" + label + "|");
			//return ("Label: |" + label + "| Visited? |" + visited + "| Value: " +
			// value.toString()); //DEBUG
		}

	}	

}
