
/**
 *
 * @author Caio Marteli
 */

public class DSAListNode 
{	

    protected Object data;
	protected DSAListNode next;
	protected DSAListNode previous;

	/************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAListNode object
    ASSERTION: sets all classfields to null
    ************************************************************/ 
	public DSAListNode()
	{
		data = null;
		next = null;
		previous = null;
	}

	/************************************************************
    Alternate Constructor:
    IMPORT: none
    EXPORT: address of new DSAListNode object
    ASSERTION: sets data fild only
    ************************************************************/ 
	public DSAListNode(Object d)
	{
		data = d;
		next = null;
		previous = null;		
	}

	/************************************************************
    Alternate Constructor:
    IMPORT: d(Object), n(DSAListNode)
    EXPORT: address of new DSAListNode object
    ASSERTION: sets data and next fields only
    ************************************************************/
	public DSAListNode(Object d, DSAListNode n)
	{
		data = d;
		next = n;
		previous = null;	
	}

	/************************************************************
    Alternate Constructor:
    IMPORT: d(Object), n(DSAListNode), p(DSAListNode)
    EXPORT: address of new DSAListNode object
    ASSERTION: sets all fields
    ************************************************************/
	public DSAListNode(Object d, DSAListNode n, DSAListNode p)
	{
		data = d;
		next = n;
		previous = p;
	}

	/************************************************************
	*** GETTERS ***
    ************************************************************/
	public DSAListNode getNext()
	{
		return next;
	}

	public DSAListNode getPrevious()
	{
		return previous;
	}

	public Object getValue()
	{
		return data;
	}

}

