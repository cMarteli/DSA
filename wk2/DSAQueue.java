import java.util.Arrays;
/**
 *
 * @author Caio Marteli
 */
public abstract class DSAQueue {

	protected int DEFAULT_CAPACITY = 5;
	protected double queue[];
    protected int currentSize; //keeps current size of queue


    
    /*
     * Default Constructor
     */
	//protected DSAQueue()
	//{		
	//}
	/**
     * Alternate Constructor
     */
	//protected DSAQueue(int maxCapacity)
	//{
	//}
    
	/**
     * adds new element to last position of stack.
     */
    protected abstract void enqueue(double data);
    
    /**
     *removes element last added to stack
     */
    protected abstract double dequeue();
    
    /*
    *returns count of queue but makes no changes 
    */
    protected abstract double peek();

    /**
     * Check if queue is full.
     */
    protected boolean isFull() 
    {
        return (currentSize == queue.length);
    }

    /**
     * Check if Queue is empty.
     */
    protected boolean isEmpty() 
    {
        return (currentSize == 0);
    }

    /**
     * prints entire queue
     */
    protected void show() 
    {
        System.out.println("queue elements: [" + Arrays.toString(queue) + "]");
    }

}
