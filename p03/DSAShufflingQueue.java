import java.util.Arrays;
/**
 * DSAShufflingQueue.java
 * @author Caio Marteli 19598552
 */
public class DSAShufflingQueue extends DSAQueue{
    
    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAShufflingQueue object
    ASSERTION: front = 0 and rear = 0 are default states
    ************************************************************/
    protected DSAShufflingQueue()
	{
        super();        
        front = 0;
        rear = 0;
	}

    /************************************************************
    OVERLOADED CONSTRUCTOR:
    IMPORT: maxSize (integer)
    EXPORT: address of new DSAShufflingQueue object
    ASSERTION: imports maxCapacity passes it to parent class contructor
    ************************************************************/
    protected DSAShufflingQueue(int maxCapacity)
	{
		super();
        front = 0;
        rear = 0;
	}

    /************************************************************
    IMPORT: data (real)
    EXPORT: none
    ASSERTION: Adds new element to last position of stack.
    ************************************************************/
    protected void enqueue(double data)
    {
        if (isFull()) 
        {
            System.out.println("Shuffling queue is full.");
        }
        else 
        {
        	rear = currentSize; 
            queue[rear] = data;
            System.out.println(data +" Added to queue.");
            if(rear < queue.length - 1)
            {
        	rear++;
            }
            currentSize++;
        }
    }
    
    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Removes element last added to queue
    ************************************************************/
    protected double dequeue()
    {
        double data = queue[front];
        //queue[rear] = 0.0;  
    	if (isEmpty())
    	{
    		System.out.println("Shuffling queue is Empty.");
    	}
    	else
    	{
            //shuffle queue
	    	for(int i = 0; i < (queue.length - 1) ; i++)
            {
                queue[i] = queue[i + 1];
            }
            queue[rear] = 0.0;
            currentSize--;
            System.out.println(data +" Removed from queue.");
    	}
    	return data;
    }

    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Returns front of queue but makes no changes
    ************************************************************/
    protected double peek()
    {
    	double data = 0.0;
    	if (isEmpty())
    	{
    		System.out.println("Stack is Empty.");
    	}
    	else
    	{
			data = queue[front-1];
    	}    	
		return data;		
    }

    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire queue
    ************************************************************/
    protected void show()
    {
        System.out.print("Displaying shuffling ");  
        super.show();
    }

}
