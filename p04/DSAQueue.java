import java.util.*;
/**
 * DSAQueue.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
public class DSAQueue implements Iterable{

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
        /*
        Object data = queue.peekFirst();
        if (queue.isEmpty())
        {
            System.out.println("Shuffling queue is Empty.");
        }
        else
        {
            //shuffle queue
            for(Iterator iter = queue.itertator(); iter.hasNext(); )
            {
                queue[i] = queue[i + 1];
            }
            queue[rear] = 0.0;
            currentSize--;
            System.out.println(data +" Removed from queue.");
        }
        return data;
        */

    //new
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
