import java.io.Serializable;
import java.util.Iterator;

/**
 * DSAQueue.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
public class DSAQueue<T extends Serializable> implements Iterable<T>{

	private DSALinkedList<T> queue;

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAQueue object
    ASSERTION: currentSize = 0 are default states
    ************************************************************/   
    protected DSAQueue() 
    {
        queue = new DSALinkedList<T>();
    }
    
	/************************************************************
    IMPORT: data (Object)
    EXPORT: none
    ASSERTION:
    ************************************************************/
    protected void enqueue(T data)
    {
        queue.insertLast(data);
    }
    
    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION:
    ************************************************************/
    protected T dequeue()
    {
        /* This needs some work
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
        T data = null;
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
    //new
       
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
    public Iterator<T> iterator()
    {
        return queue.iterator();
    }

    /************************************************************
    *** GETTERS ***
    ************************************************************/
    protected T peekFirst()
    {
        return queue.peekFirst();
    }

    protected T peekLast()
    {
        return queue.peekLast();
    }    


}
