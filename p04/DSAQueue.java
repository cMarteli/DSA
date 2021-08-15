import java.util.*;
/**
 * DSAQueue.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
public abstract class DSAQueue implements Iterable{

	private DSALinkedList queue;

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAQueue object
    ASSERTION: currentSize = 0 are default states
    ************************************************************/   
    protected DSAQueue() 
    {
        queue = new DSALinkedList();
    }
    
	/************************************************************
    IMPORT: data (Object)
    EXPORT: none
    ASSERTION:
    ************************************************************/
    protected void enqueue(Object data)
    {
        queue.insertLast(data);
    }
    
    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION:
    ************************************************************/
    protected Object dequeue()
    {
       return queue.removeFirst();
    }

    /************************************************************
    IMPORT: none
    EXPORT: (boolean)
    ASSERTION: Check if queue is empty.
    ************************************************************/
    protected boolean isEmpty() 
    {
        return queue.isEmpty();
    }
    
    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire queue
    ************************************************************/
    protected void show() 
    {
        queue.show();
    }

    /************************************************************
    IMPORT: none
    EXPORT: iterator
    ASSERTION: Exposes lists iterator
    ************************************************************/
    public Iterator iterator()
    {
        return queue.iterator();
    }

    /************************************************************
    *** GETTERS ***
    ************************************************************/
    protected Object peekFirst()
    {
        return queue.peekFirst();
    }

    protected Object peekLast()
    {
        return queue.peekLast();
    }    


}
