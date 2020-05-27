import java.util.*;
/**
 *
 * @author Caio Marteli
 */
public class DSAGraph 
{
	public DSALinkedList vertices;

	/**
	*  Constructor: sets key and value only
	*/
	public DSAGraph() 
	{

	}
	//Mutators
	public void addVertex(String label,)
	{

	}

	public void addEdge(String label1, String label2)
	{

	}

	public boolean hasVertex(String label)
	{
		return boolean;
	}

	public int getVertexCount()
	{
		return int;
	}

	public int getEdgeCount()
	{
		return int;
	}

	public DSAGraphVertex getVertex(String label)
	{
		return DSAGraphVertex;

	}
	//exports vertex list?
	public DSAGraphVertex getAdjacent(String label)
	{
		return DSAGraphVertex;		
	}
	public boolean isAdjacent(String label1, String label2)
	{
		return boolean;
	}

	public void displayAsList()
	{

	}

	public void displayAsMatrix()
	{
		
	}

}

public class DSAGraphVertex
{
	//fields
	String label;
	String value[];
	DSALinkedList links, visited;

	//CONSTRUCTOR
	public DSAGraphVertex(String inLabel, String inValue)
	{

	}

	//ACCESSORS
	public String getLabel()
	{
		return String;
	}
	//change is don't want value to be a string
	public String getValue()
	{
		return String;

	}
	//should return verrtices list
	public DSAGraphVertex getAdjacent()
	{
		return /*here*/;
	}

	public void addEdge(DSAGraphVertex vertex)
	{

	} 
	public void setVisited()
	{

	}
	//for searching (later)
	public void clearVisited()
	{

	}
	public boolean getVisited()
	{
		return boolean;

	}  
	public String toString()
	{
		return String;
	}


}