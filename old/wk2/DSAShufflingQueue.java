
/**
 *
 * @author Caio Marteli
 */
public class DSAShufflingQueue extends DSAQueue{
    /**
	 * Default Constructor
	 */
    protected DSAShufflingQueue()
	{
        super();        
        front = 0;
        rear = 0;
	}
	/**
     * Alternate Constructor
	 */
    protected DSAShufflingQueue(int maxCapacity)
	{
		super();
        front = 0;
        rear = 0;
	}

	/**
     * adds new element to last position of queue.
     */
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
    /**
     *removes element last added to queue
     */
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
    /*
    *returns front of queue but makes no changes 
    */
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
    /*
    *prints entire queue
    */
    protected void show()
    {
        System.out.print("Displaying shuffling ");  
        super.show();
    }

}
