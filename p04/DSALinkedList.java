import java.util.Iterator;
import java.io.Serializable;
/**
 *
 * @author Caio Marteli
 *
 *Contains Iterator Class AND DSAListNode
 */
public class DSALinkedList<T> implements Iterable<T>, Serializable{

	protected DSAListNode<T> head;
	protected DSAListNode<T> tail;

	
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
	public void insertFirst(T data)
	{
		DSAListNode<T> node = new DSAListNode<T>(data, head); //creates new node to store old head
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
	public void insertLast(T data)
	{
		DSAListNode<T> node =  new DSAListNode<T>(data); //stores data; head and tail are set to null

		if(isEmpty()) //if list is empty make node new head
		{
			head = node;
		}
		else
		{
			DSAListNode<T> n = head;
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
	public T peekFirst()
	{
		return head.getValue();
	}

	/************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Returns tail of list but makes no changes
    ************************************************************/
	public T peekLast()
	{
		return tail.getValue();		
	}

    /************************************************************
    IMPORT: none
    EXPORT: (DSAListNode)
    ASSERTION: Removes element at head of list
    ************************************************************/
	public T removeFirst()
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
	public T removeLast()
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
		Iterator<T> iter = this.iterator();

		while(iter.hasNext())
		{
            System.out.println(iter.next()); //iterates over list
		}
	}

	/************************************************************
    DSALinkedListNode Class
    Private inner Cass
    ************************************************************/
	private class DSAListNode<T>
	{	

	    private T data;
		private DSAListNode<T> next;
		private DSAListNode<T> previous;

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
		public DSAListNode(T d)
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
		public DSAListNode(T d, DSAListNode<T> n)
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
		public DSAListNode(T d, DSAListNode<T> n, DSAListNode<T> p)
		{
			data = d;
			next = n;
			previous = p;
		}

		/************************************************************
		*** GETTERS ***
	    ************************************************************/
		public DSAListNode<T> getNext()
		{
			return next;
		}

		public DSAListNode<T> getPrevious()
		{
			return previous;
		}

		public T getValue()
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
	public Iterator<T> iterator()
	{
		return new DSALinkedListIterator(this);
	}

    /************************************************************
    DSALinkedListIterator Class
    Private inner class - implements Iterator 
    ************************************************************/
	private class DSALinkedListIterator implements Iterator<T>
	{
		private DSAListNode<T> iterNext; //cursor
		
		public DSALinkedListIterator(DSALinkedList<T> theList) 
		{
			iterNext = theList.head;  //NOTE: Able to access private field of MyLinkedList		
		}

		public boolean hasNext() //Iterator interface implementation
		{
			return (iterNext != null); 
		}

		public T next() 
		{ 
			T value;
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

		public void remove() //STUB
		{ 
			throw new UnsupportedOperationException("Not supported"); 
		}
	}//end of iterator


}//end of DSALinkedList.java