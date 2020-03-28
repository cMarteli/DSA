/**
 *
 * @author Caio Marteli
 */
public class DSALinkedList {

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
		return head.data;
	}

	public Object peekLast()
	{
		return tail.data;		
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

}
