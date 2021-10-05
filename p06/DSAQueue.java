import java.io.Serializable;
import java.util.Iterator;

/**
 * DSAQueue.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
@SuppressWarnings("unchecked")
public class DSAQueue implements Iterable<DSAQueue>, Serializable{

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
        Object data = null;
        if (queue.isEmpty())
        {
            throw new IllegalArgumentException("Queue is Empty.");
        }
        else //if not empty dequeue
        {
            data = queue.peekFirst();
            queue.removeFirst();
        }
        return data;       
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
    public Iterator<DSAQueue> iterator()
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
