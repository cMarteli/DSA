
/**
 *
 * @author Caio Marteli
 */
public class DSAShufflingQueue extends DSAQueue{

	//protected int DEFAULT_CAPACITY = 5;
	//protected double queue[];

	protected int count; //keeps index of last element in queue
    /**
	 * Default Constructor
	 */
    protected DSAShufflingQueue()
	{
		queue = new double[DEFAULT_CAPACITY];
		count = 0;
	}
	/**
     * Alternate Constructor
	 */
    protected DSAShufflingQueue(int maxCapacity)
	{
		queue = new double[maxCapacity];
		count = 0;
	}
    /**
     * accessor for count.
     */
    protected int getCount()
    {
        return count;
    }

	/**
     * adds new element to last position of queue.
     */
    protected void enqueue(double data)
    {
    	queue[count] = data;
    	count++;
    }
    /**
     *removes element last added to queue
     */
    protected double dequeue()
    {
    	double data = 0.0;
    	if (isEmpty())
    	{
    		System.out.println("Queue is Empty.");
    	}
    	else
    	{
	    	count--;//changes position of count to one back
	    	data = queue[count];
	    	queue[count] = 0.0;//resets element to zero
    	}
    	return data;
    }
    /*
    *returns count of queue but makes no changes 
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
			data = queue[count-1];
    	}    	
		return data;		
    }
    /*
    *prints entire queue
    */
    protected void show()
    {
        System.out.print("Shuffling ");  
        super.show();
    }

    protected boolean isEmpty()
    {
    	boolean pass = false;    	
    	if(count == 0)
    	{
    		pass = true;
    	}
    	return pass;
    }

}
