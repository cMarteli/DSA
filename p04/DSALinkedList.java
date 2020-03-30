import java.util.*;
/**
 *
 * @author Caio Marteli
 */
public class DSALinkedList implements Iterable{

	protected DSAListNode head;
	protected DSAListNode tail;

	
	/*
	*	Default constructor sets values to null
	*/
	public DSALinkedList()
	{
		head = null;
		tail = null;
	}

	/*
	* Creates a new node and parses data into it
	*/
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

	/*
	 * Creates a new node and parses data into it
	 */
	public void insertFirst(Object data)
	{
		DSAListNode node = new DSAListNode(data,head); //makes it point to head
		if(isEmpty())
		{
			tail = node;
		}

		head = node; //moves the head to new node

	}
	/*
	 * Creates a new node and parses data into it
	 */
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

	/*
	 * remove methods
	 */
	
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

}


