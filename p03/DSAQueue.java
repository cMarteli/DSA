import java.util.Arrays;
/**
 * DSAQueue.java
 * @author Caio Marteli 19598552
 */
public abstract class DSAQueue {

	protected int DEFAULT_CAPACITY = 5;
	protected double queue[];
    protected int currentSize; //keeps current size of queue
    protected int front; //keeps current front of queue
    protected int rear; //keeps current rear of queue


    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAQueue object
    ASSERTION: currentSize = 0 are default states
    ************************************************************/   
    protected DSAQueue() 
    {
        queue = new double[DEFAULT_CAPACITY];
        currentSize = 0;
    }
    
    /************************************************************
    OVERLOADED CONSTRUCTOR:
    IMPORT: maxSize (integer)
    EXPORT: address of new DSAQueue object
    ASSERTION: imports maxSize passes it to parent class contructor
    ************************************************************/
    protected DSAQueue(int maxSize) 
    {
        queue = new double[maxSize];
        currentSize = 0;
    }
    
	/************************************************************
    IMPORT: data (real)
    EXPORT: none
    ASSERTION: ABSTRACT
    ************************************************************/
    protected abstract void enqueue(double data);
    
    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: ABSTRACT
    ************************************************************/
    protected abstract double dequeue();
    
    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: ABSTRACT
    ************************************************************/
    protected abstract double peek();

    /************************************************************
    IMPORT: none
    EXPORT: (boolean)
    ASSERTION: Check if queue is full.
    ************************************************************/
    protected boolean isFull() 
    {
        return (currentSize == queue.length);
    }

    /************************************************************
    IMPORT: none
    EXPORT: (boolean)
    ASSERTION: Check if queue is empty.
    ************************************************************/
    protected boolean isEmpty() 
    {
        return (currentSize == 0);
    }
    
    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire queue
    ************************************************************/
    protected void show() 
    {
        System.out.println("queue elements: [" + Arrays.toString(queue) + "]");
    }

    /*** GETTERS ***/
    
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

}
