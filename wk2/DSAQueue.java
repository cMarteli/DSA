import java.util.Arrays;
/**
 *
 * @author Caio Marteli
 */
public class DSAQueue {

	protected int DEFAULT_CAPACITY = 5;
	protected double queue[];

    protected int size; //keeps current size of queue
	protected int front; //keeps index of first element in queue
    protected int rear; //keeps index of last element in queue

	//Default Constructor
	protected DSAQueue()
	{
		queue = new double[DEFAULT_CAPACITY];
		front = 0;
        rear = 0;
        size = 0;
	}
	//Alternate Constructor
	protected DSAQueue(int maxCapacity)
	{
		queue = new double[maxCapacity];
		front = -1;
        rear = -1;
        size = 0;
	}
	//adds new element to last position of stack.
    protected void enqueue(double data)
    {
    	queue[rear] = data;
    	rear = (rear + 1) % queue.length;
        size++;
    }

    //removes element first added to queue
    protected double dequeue()
    {    	
    	double data = queue[front];
        queue[front] = 0.0;
        front = (front + 1) % queue.length;
    	size--;

	   	return data;
    }
/*
    //returns count of queue but makes no changes 
    protected double peek()
    {
    	double data = 0.0;
    	if (isEmpty())
    	{
    		System.out.println("Stack is Empty.");
    	}
    	else
    	{
			data = queue[count-1];
    	}    	
		return data;		
    }
*/

    /**
    * Check if queue is empty.
    */
    protected boolean isEmpty()
    {
        return(size == 0);
    }

    /**
    * Check if queue is full.
    */
    protected boolean isFull() 
    {
        return (size == queue.length);
    }

    //prints entire queue
    protected void show()
    {
    System.out.println("CircularQueue [" + Arrays.toString(queue) + "]");
    }

}
