import java.util.*;
/**
 *
 * @author Caio Marteli
 */
public class DSALinkedList implements Iterable{

	protected DSAListNode head;
	protected DSAListNode tail;

	/************************************************************
	CONSTRUCTOR:
	IMPORT: none
	EXPORT: address of new Linked List
	ASSERTION: sets values to null
	************************************************************/
	public DSALinkedList()
	{
		head = null;
		tail = null;
	}

	/************************************************************
	IMPORT: none
	EXPORT: boolean
	ASSERTION: Checks if list is empty
	************************************************************/
	public boolean isEmpty()
	{
		boolean isEmp = false;
		if(head == null)
		{
			isEmp = true;
		}
		else
		{
			isEmp = false;
		}
		return isEmp;
	}


	/************************************************************
	IMPORT: data (Object)
	EXPORT: void
	ASSERTION: Creates a new node, parses data into it and inserts it at front
	************************************************************/
	public void insertFirst(Object data)
	{
		DSAListNode node = new DSAListNode(data,head); //makes it point to head
		if(isEmpty())
		{
			tail = node;
		}

		head = node; //moves the head to new node

	}
	/************************************************************
	IMPORT: data (Object)
	EXPORT: void
	ASSERTION: Creates a new node, parses data into it and inserts it at back
	************************************************************/
	public void insertLast(Object data)
	{
		DSAListNode node = new DSAListNode(data); //makes it point to null
		//node.data = data;
		//node.next = null;

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

	/*
	 *getters
	 */
	
	public Object peekFirst()
	{
		return head.getValue();
	}

	public Object peekLast()
	{
		return tail.getValue();		
	}

	/************************************************************
	IMPORT: none
	EXPORT: Object
	ASSERTION: Removes node at head
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
		return head;
	}

	/************************************************************
	IMPORT: none
	EXPORT: Object
	ASSERTION: Removes node at tail
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
		return tail;
	}
	
	/************************************************************
	IMPORT: none
	EXPORT: none
	ASSERTION: prints list to terminal
	************************************************************/
	public void show()
	{
		DSAListNode node = head;

		while(node.next != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
	
	/************************************************************
	IMPORT: none
	EXPORT: Object
	ASSERTION: Removes node at head
	************************************************************/
	public Iterator iterator()
	{
		return new DSALinkedListIterator(this);
	}

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

		public void remove() 
		{ 
			throw new UnsupportedOperationException("Not supported"); 
		}
	}

/************************************************************
CLASS: DSAListNode
ACCESS: Private
ASSERTION: Inner class of DSALinkedList, holds the actual data
************************************************************/
private class DSAListNode 
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


	//getters

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

}