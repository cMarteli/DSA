
/**
 *
 * @author Caio Marteli
 */

public class DSAListNode 
{	

    protected Object data;
	protected DSAListNode next;
	protected DSAListNode previous;

	/**
     *  Default constructor sets all classfields to null
     */	
	public DSAListNode()
	{
		data = null;
		next = null;
		previous = null;
	}
	/**
     *  Alternate constructor sets data only
     */
	public DSAListNode(Object d)
	{
		data = d;
		next = null;
		previous = null;		
	}
	/**
     *  Alternate constructor sets all fields
     */
	public DSAListNode(Object d, DSAListNode n)
	{
		data = d;
		next = n;		
	}

	/**
     *  Alternate constructor sets all fields
     */
	public DSAListNode(Object d, DSAListNode n1, DSAListNode n2)
	{
		data = d;
		next = n1;
		previous = n2;
	}

}

