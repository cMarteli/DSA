import java.io.Serializable;
import java.util.Iterator;
/**
 *
 * @author Caio Marteli
 *
 *Contains Iterator Class AND DSAListNode
 */
@SuppressWarnings("unchecked")
public class DSALinkedList implements Iterable<DSALinkedList>, Serializable{

	protected DSAListNode head;
	protected DSAListNode tail;
	
    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSALinkedList object
    ASSERTION: head = null and tail = null are the default states
    ************************************************************/ 
	public DSALinkedList()
	{
		head = null;
		tail = null;
	}

   /************************************************************
    IMPORT: none
    EXPORT: (boolean)
    ASSERTION: Check if list is empty.
    ************************************************************/
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    /************************************************************
    IMPORT: data (Object)
    EXPORT: none
    ASSERTION: Adds new element to first position of list.
    ************************************************************/
	public void insertFirst(Object data)
	{
		DSAListNode node = new DSAListNode(data, head); //creates new node to store old head
		if(isEmpty())
		{
			tail = node; //if data is the only node, head is also tail
		}
		head = node; //moves the head to new node
	}

    /************************************************************
    IMPORT: data (Object)
    EXPORT: none
    ASSERTION: Adds new element to last position of list.
    ************************************************************/
	public void insertLast(Object data)
	{
		DSAListNode node =  new DSAListNode(data); //stores data; head and tail are set to null

		if(isEmpty()) //if list is empty make node new head
		{
			head = node;
		}
		else
		{
			DSAListNode n = head;
			while(n.next != null)
			{
				n = n.next;
			}
			node.previous = n; //keeps track of previous
			n.next = node;
		}
		tail = node;//keeps track of tail
	}

    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Returns head of list but makes no changes
    ************************************************************/
	public Object peekFirst()
	{
		return head.getValue();
	}

	/************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Returns tail of list but makes no changes
    ************************************************************/
	public Object peekLast()
	{
		return tail.getValue();		
	}

    /************************************************************
    IMPORT: none
    EXPORT: (DSAListNode)
    ASSERTION: Removes element at head of list
    ************************************************************/
	public Object removeFirst()
	{

		if(isEmpty())
		{
			System.out.println("List is Empty");
		}
		else if(head == tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			head = head.next;
			head.previous = null;
		}
		return head.getValue();
	}
    /************************************************************
    IMPORT: none
    EXPORT: (DSAListNode)
    ASSERTION: Removes element at tail of list
    ************************************************************/
	public Object removeLast()
	{
		if(isEmpty())
		{
			System.out.println("List is Empty");
		}
		else if(head == tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			tail = tail.previous;
			tail.next = null;
		}
		return tail.getValue();
	}
	
    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire list using iterator
    ************************************************************/
	public void show()
	{
		Iterator<DSALinkedList> iter = this.iterator();

		while(iter.hasNext())
		{
            System.out.println(iter.next()); //iterates over list
		}
	}

	/************************************************************
    DSALinkedListNode Class
    Private inner Cass
    ************************************************************/
	private class DSAListNode implements Serializable
	{	

	    private Object data;
		private DSAListNode next;
		private DSAListNode previous;

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
	    Constructor:
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

	}//end of node class

    /************************************************************
    Iterator Constructor:
    IMPORT: none
    EXPORT: address of new DSALinkedListIterator object
    ASSERTION: 
    ************************************************************/ 
	public Iterator iterator()
	{
		return new DSALinkedListIterator(this);
	}

    /************************************************************
    DSALinkedListIterator Class
    Private inner class - implements Iterator 
    ************************************************************/
	private class DSALinkedListIterator implements Iterator
	{
		private DSAListNode iterNext; //cursor
		
		public DSALinkedListIterator(DSALinkedList theList) 
		{
			iterNext = theList.head;  //NOTE: Able to access private field of MyLinkedList		
		}

		public boolean hasNext() //Iterator interface implementation
		{
			return (iterNext != null); 
		}

		public Object next() 
		{ 
			Object value;
			if(iterNext == null)
			{
			    value = null;
			}
			else
			{
			    value = iterNext.getValue();  //Get the value in the node
			    iterNext = iterNext.getNext(); //Ready for subsequent calls to next()
			}
			return value;
		}

		public void remove() //Not implemented
		{ 
			throw new UnsupportedOperationException("Not supported"); 
		}
	}//end of iterator


}//end of DSALinkedList.java