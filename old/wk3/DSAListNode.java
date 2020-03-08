
/**
 *
 * @author Caio Marteli
 */

public class DSAListNode 
{	

    protected Object data;
	protected DSAListNode next;

	/**
     *  Default constructor sets all classfields to null
     */	
	public DSAListNode()
	{
		data = null;
		next = null;
	}
	/**
     *  Alternate constructor sets data only
     */
	public DSAListNode(Object d)
	{
		data = d;
		next = null;		
	}
	/**
     *  Alternate constructor sets all fields
     */
	public DSAListNode(Object d, DSAListNode n)
	{
		data = d;
		next = n;		
	}

}

