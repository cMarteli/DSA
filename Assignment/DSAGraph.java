import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * DSAGraph.java
 * @author Caio Marteli (19598552)
 * Handles all graph operations, dependancies: DSALinked List, DSAQueue, DSAStack
 */
// Marteli, C (2021) DSAPrac6 source code (Version 2.0) [Source code]. https://github.com/cMarteli/DSA
// Modified and improved October 2021 for gameofcatz.java
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
	IMPORT: label (String), value (Object)
	EXPORT: none
	ASSERTION: adds new vertex to with label only and sets value to null
	two or more vertices can not have the same label.
	************************************************************/
	public boolean addVertex(String label)
	{
		if(!hasVertex(label)) //if edge does not already exist add it
		{
			DSAGraphVertex v = new DSAGraphVertex(label, null);
			vertices.insertLast(v); //inserts into vertices list at end
			return true;
		}
		else
		{
			return false;
		}
	}

	/************************************************************
	IMPORT: label (String), value (Object)
	EXPORT: boolean (true if vertex was added, false if not)
	ASSERTION: Overloaded method. Adds new vertex to with label and value,
	two or more vertices can not have the same label.
	************************************************************/
	public boolean addVertex(String label, Object value)
	{
		if(!hasVertex(label)) //if edge does not already exist add it
		{
			DSAGraphVertex v = new DSAGraphVertex(label, value);
			vertices.insertLast(v); //inserts into vertices list at end
			return true;
		}
		else
		{
			return false;
		}
	}

	/************************************************************
	IMPORT: label1 (String), label2 (String)
	EXPORT: boolean (true if edge was added, false if not)
	ASSERTION: Checks if an edge exists and then adds edge between 2 parameter nodes
	************************************************************/

	public boolean addEdge(String label1, String label2)
	{
		if(!isAdjacent(label1, label2)) //if edge does not already exist add it
		{
			DSAGraphVertex vx1 = getVertex(label1), vx2 = getVertex(label2);
			vx1.addEdge(vx2);
			vx2.addEdge(vx1);
			edgeCount++;
			return true;
		}
		else
		{
			return false;
		}
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: none
	ASSERTION: checks if a vetex exists by label then deletes it
	************************************************************/
	public boolean removeVertex(String label)
	{
		if(hasVertex(label)) //if vertex in in list
		{
			vertices.removeAt(getVertex(label));
			//System.out.println("Deleted: " + label); //debug
			return true;
		}
		else
		{
			return false;
		}
	}


	/************************************************************
	IMPORT: label1 (String), label2 (String)
	EXPORT: boolean (true if edge was removed, false if not)
	ASSERTION: Checks if an edge exists and then removes edge between 2 parameter nodes
	************************************************************/

	public boolean removeEdge(String label1, String label2)
	{
		if(isAdjacent(label1, label2)) //if edge exists remove it
		{
			DSAGraphVertex vx1 = getVertex(label1), vx2 = getVertex(label2);
			vx1.removeEdge(vx2);
			vx2.removeEdge(vx1);
			edgeCount--;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**************************************************
	VALIDATORS
	**************************************************/

	/************************************************************
	IMPORT: label (String)
	EXPORT: boolean
	ASSERTION: check if vertices list has the node from label
	************************************************************/
	public boolean hasVertex(String label)
	{
		boolean sucess;
		try {
			getVertex(label);
			sucess = true;
		} catch (NoSuchElementException e) {
			sucess = false;
		}
		return sucess;
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: bool (DSALinkedList)
	ASSERTION: checks if two nodes are adjacent (if an edge exists) returns true if it does
	************************************************************/
	public boolean isAdjacent(String label1, String label2)
	{
		boolean found = false;
		try {
			DSAGraphVertex temp, vx1 = getVertex(label1);
			DSALinkedList adjList = vx1.getAdjacent();
			Iterator<DSAGraphVertex> itr = adjList.iterator(); // - Maybe needs to check instance?
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
		} catch (NoSuchElementException e) {
			//Handles exception thrown by getVertex()
			found = false;
		}
		return found;
	}

	/************************************************************
	IMPORT: oldLabel (String), newLabel (String)
	EXPORT: boolean
	ASSERTION: rename label if vertices list has the label given
	Throws: IllegalArgumentException
	************************************************************/
	public boolean changeVxLabel(String oldLabel, String newLabel)
	{
		boolean sucess = false;
		try {
			DSAGraphVertex vx = getVertex(oldLabel);
			if(!hasVertex(newLabel)) //replace only if new label isn't already taken
			{
				vx.label = newLabel;
				sucess = true;
			}
			else
			{
				throw new IllegalArgumentException("|" + newLabel + "| already exists");
			}

		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException(e.getMessage()); //vx doesn't exist
		}
		return sucess;
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

	/************************************************************
	TRAVERSAL
	************************************************************/
	/************************************************************
	IMPORT: label (String)
	EXPORT: queue (DSAQueue)
	ASSERTION: Wrapper for DEPTH FIRST SEARCH Imports start point, Exports queue of objs in traversal order
	Throws: NoSuchElementException
	************************************************************/
	public DSAQueue depthFirstSearch(String start)
	{
		if(!vertices.isEmpty())
		{
			DSAQueue queue = new DSAQueue();
			DSAGraphVertex vx = getVertex(start); //vertex to start on (root)
			DSAStack visited = new DSAStack();	//creates empty stack

			clear(); //sets all vertices as not visited
			vx.setVisited(); // Marks root as visited
			queue.enqueue(vx); //start point

			dfs(vx, visited, queue); //begin recursion

			return queue;
		}
		else
		{
			throw new NoSuchElementException("List is empty");
		}
	}

	/************************************************************
	IMPORT: label (String)queue
	EXPORT: bool (DSALinkedList)
	ASSERTION: DEPTH FIRST SEARCH Recur for all the vertices adjacent
	to vx while stack is not empty
	************************************************************/
	public void dfs(DSAGraphVertex vx, DSAStack visited, DSAQueue queue)
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
							dfs(vx, visited, queue);
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
	TRAVERSAL2
	************************************************************/

	/************************************************************
	IMPORT: label (String)
	EXPORT: queue (DSAQueue)
	ASSERTION: TODO
	Throws: NoSuchElementException
	************************************************************/
	public DSAQueue breadthFirstSearch(String start, String target)
	{
		if(!vertices.isEmpty())
		{
			DSAQueue queue = new DSAQueue();
			DSAStack visited = new DSAStack();	//creates empty stack
			DSAGraphVertex vx = getVertex(start); //vertex to start on (root)
			DSAGraphVertex dest = getVertex(target); //vertex to start on (dest)

			clear(); //sets all visited on all vertices == false
			vx.setVisited(); // Marks root as visited
			queue.enqueue(vx); //adds start point to queue

			bfs(vx, visited, queue, dest); //begin recursion

			queue.enqueue(dest); //if successful adds destination to queue

			return queue;
		}
		else
		{
			throw new NoSuchElementException("List is empty or start or end elements don't exist");
		}
	}

	/************************************************************
	IMPORT: label (String)queue
	EXPORT: bool (DSALinkedList)
	ASSERTION:
	************************************************************/
	public void bfs(DSAGraphVertex vx, DSAStack visited, DSAQueue queue, DSAGraphVertex target)
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
						if(!vx.getVisited() && !vx.equals(target)) //if not visited and is not target traverse here
						{
							queue.enqueue(vx); //adds to output queue
							vx.setVisited(); //sets to visited
							bfs(vx, visited, queue, target);
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
	IMPORT: none
	EXPORT: count (integer)
	ASSERTION: helper method for traversal methods
	iterates through vertices list and clears visited from each
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
	IMPORT: none
	EXPORT: boolean
	ASSERTION: Iterates through vertices list and prints all edges
	************************************************************/
	public void printEdges()
	{
		System.out.println("Printing all Edges:");
		Iterator<DSAGraphVertex> itr = vertices.iterator();
		while(itr.hasNext())
		{
			itr.next().printAdjacent();
		}
	}

	/************************************************************
	MUTATORS
	************************************************************/
	/************************************************************
	IMPORT: label (String)
	EXPORT: target (DSAGraphVertex)
	ASSERTION: iterates through vertices list w/ a label and returns target if found
	Throws: NoSuchElementException
	************************************************************/
	public DSAGraphVertex getVertex(String label)
	{
		DSAGraphVertex temp, target = null;
		Iterator<DSAGraphVertex> itr = vertices.iterator();
		if(vertices.isEmpty()) // case: list is empty
		{
			throw new NoSuchElementException("Vertices list is empty.");
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

		return target;
	}

	/************************************************************
	IMPORT: label (String)
	EXPORT: getAdjacent (DSALinkedList)
	ASSERTION: returns the adjacency list from vxnode using label
	************************************************************/
	public DSALinkedList getAdjacent(String label)
	{
		DSAGraphVertex vx = getVertex(label);
		return vx.getAdjacent();
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
	ASSERTION: accessor for global var edgeCount
	************************************************************/
	public int getEdgeCount()
	{
		return edgeCount;
	}


	/************************************************************
	IMPORT: none
	EXPORT: none
	ASSERTION: Display vertices list
	************************************************************/
	public void displayAsList()
	{
		System.out.println("Printing all vertices");
		vertices.show();
	}


	/************************************************************
	PRIVATE INNER CLASS - DSAGraphVertex
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
			System.out.println("Links to: " + label);
			if(links.isEmpty())
			{
				System.out.println("NONE");
			}
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
		public void removeEdge(DSAGraphVertex inVertex)
		{
			links.removeAt(inVertex); //Removes specific edge
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
