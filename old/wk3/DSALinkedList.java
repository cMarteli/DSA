
/**
 *
 * @author Caio Marteli
 */
public class DSALinkedList {

	protected DSAListNode head;

	/*
	 * Creates a new node and parses data into it
	 */
	public void insertFirst(Object data)
	{
		DSAListNode node = new DSAListNode(data,head); //makes it point to head 

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

		if(head == null) //if list is empty make node new head
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
			n.next = node;
		}
	}

	/*
	 *getters
	 */
	
	public Object peekFirst()
	{
		return head.data;
	}
/*
	public Object peekLast()
	{
		DSAListNode node = new DSAListNode(data);		
		if(head == null) //if list is empty make return head
		{
			node = head;
		}
		else
		{
			DSAListNode n = head;
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = node;
		}
		
	}

	/*
	 * remove methods
	 */
	/*
	public Object removeFirst()
	{
		
	}

	public Object removeLast()
	{
		
	}
	*/

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
