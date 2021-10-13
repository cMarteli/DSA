import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Caio Marteli
 * Adjacency List Graph
 */
@SuppressWarnings("unchecked")
public class DSAGraph implements Serializable
{
	private DSALinkedList vertices;
	private int edgeCount;

	/************************************************************
	CONSTRUCTOR:
	IMPORT: none
	EXPORT: address of new DSA Graph
	ASSERTION: creates empty linked list, edge count of 0 is default value
	************************************************************/
	public DSAGraph()
	{
		vertices = new DSALinkedList();
		edgeCount = 0;
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
		if(!isAdjacent(label1, label2)) //if edge does not already exist add it
		{
			DSAGraphVertex vx1 = getVertex(label1), vx2 = getVertex(label2);
			vx1.addEdge(vx2);
			vx2.addEdge(vx1);
			edgeCount++;
		}
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

	/************************************************************
	IMPORT: none
	EXPORT: edgeCount (integer)
	ASSERTION: getter
	************************************************************/
	public int getEdgeCount()
	{
		return edgeCount;
	}

	/************************************************************
	IMPORT: none
	EXPORT: boolean
	ASSERTION: returns empty if there are no vertices
	************************************************************/

	public boolean isEmpty()
	{
		return vertices.isEmpty();
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
	ASSERTION: returns the adjacency list from node w/ label
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
		if(!adjList.isEmpty()) // if list is not empty
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

	/************************************************************
	IMPORT: label (String)
	EXPORT: getAdjacent (DSALinkedList)
	ASSERTION: STUB
	************************************************************/
	public DSALinkedList removeVertex(String label)
	{
		DSAGraphVertex vx = getVertex(label);
		return vx.getAdjacent();
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
	IMPORT: label (String)queue
	EXPORT: bool (DSALinkedList)
	ASSERTION: DEPTH FIRST SEARCH Recur for all the vertices adjacent to vx while stack is not empty
	************************************************************/
	public void DFSUtil(DSAGraphVertex vx, DSAStack visited, DSAQueue queue)
	{
		try {
			if(vx != null) //base case if it's null end recursion
			{
				visited.push(vx); //push onto visited stack

				Iterator<DSAGraphVertex> itr = vx.getAdjacent().iterator();

				do{
					while (itr.hasNext())
					{
						vx = itr.next();
						if(!vx.getVisited()) //if not visited traverse here
						{
							queue.enqueue(vx); //adds to output queue
							vx.setVisited(); //sets to visited
							DFSUtil(vx, visited, queue);
						}
					}
					visited.pop();

				} while(!visited.isEmpty());
			}
		}
		catch (IllegalArgumentException e) //catches empty stack exceptions
		{
			//System.out.println(e.getMessage());
		}

	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: queue (DSAQueue)
	ASSERTION: Wrapper DEPTH FIRST SEARCH returns q of objs in traversal order
	************************************************************/
	public DSAQueue depthFirstSearch()
	{
		if(!vertices.isEmpty())
		{
			DSAQueue queue = new DSAQueue();
			clear(); //sets all visited on all vertices == false
			DSAGraphVertex vx = (DSAGraphVertex)vertices.peekFirst(); //picks head of vertices list to start on
			DSAStack visited = new DSAStack();	//creates empty stack
			vx.setVisited(); // Marks vx visited == true
			queue.enqueue(vx); //start point

			DFSUtil(vx, visited, queue); //begin recursion

			return queue;
		}
		else
		{
			throw new NoSuchElementException("List is empty");
		}
	}

	/************************************************************
	PRIVATE INNER CLASS
	************************************************************/
	private class DSAGraphVertex implements Serializable
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
		@Override
		public String toString()
		{
			return("|" + label + "|");
		}

	}

}
