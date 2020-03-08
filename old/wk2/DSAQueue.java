import java.util.Arrays;
/**
 *
 * @author Caio Marteli
 */
public abstract class DSAQueue {

	protected int DEFAULT_CAPACITY = 5;
	protected double queue[];
    protected int currentSize; //keeps current size of queue
    protected int front; //keeps current front of queue
    protected int rear; //keeps current rear of queue


    
    protected DSAQueue() 
    {
        queue = new double[DEFAULT_CAPACITY];
        currentSize = 0;
    }
     /**
     * Alternate constructor.
     */
    protected DSAQueue(int maxSize) 
    {
        queue = new double[maxSize];
        currentSize = 0;
    }
    
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

    protected int getFront()
    {
        return front;
    }

    protected int getRear()
    {
        return rear;
    }

    protected int getCurrentSize()
    {
        return currentSize;
    }

    /**
     * prints entire queue
     */
    protected void show() 
    {
        System.out.println("queue elements: [" + Arrays.toString(queue) + "]");
    }

}
