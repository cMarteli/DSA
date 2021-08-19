import java.util.*;
/**
 *
 * @author Caio Marteli
 */
public class DSAGraph 
{
	public DSALinkedList vertices;

	/************************************************************
	CONSTRUCTOR:
	IMPORT: none
	EXPORT: address of new DSA Graph
	ASSERTION: sets key and value only
	************************************************************/
	public DSAGraph() 
	{		

	}
	//Mutators
	public void addVertex(String label)
	{
		
	}
	//STUBBED
	public void addEdge(String label1, String label2)
	{

	}
	//STUBBED
	public boolean hasVertex(String label)
	{
		return false;
	}
	//STUBBED
	public int getVertexCount()
	{
		return 0;
	}
	//STUBBED
	public int getEdgeCount()
	{
		return 0;
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
		return false;
	}
	//STUBBED METHOD!
	public void displayAsList()
	{
		System.out.println("STUB");

	}
	//STUBBED METHOD!
	public void displayAsMatrix()
	{
		System.out.println("STUB");
	}

	

}
//	NEW CLASS VERTEX!!!!!!!
private class DSAGraphVertex
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
		return false;

	}  
	public String toString()
	{
		return String;
	}

}