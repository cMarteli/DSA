
/**
 *
 * @author Caio Marteli
 */
public class DSAStack {

	protected int DEFAULT_CAPACITY = 5;
	protected double stack[];
	protected int count; //keeps index of last element in stack

	/*
    * Default Constructor
	*/
    protected DSAStack()
	{
		stack = new double[DEFAULT_CAPACITY];
		count = 0;
	}
	/**
     * Alternate Constructor
	 */
    protected DSAStack(int maxCapacity)
	{
		stack = new double[maxCapacity];
		count = 0;
	}
	/**
     * adds new element to last position of stack.
     */
    protected void push(double data)
    {
    	stack[count] = data;
    	count++;
    }

    /**
     * removes element last added to stack
     */
    protected double pop()
    {
    	double data = 0.0;
    	if (isEmpty())
    	{
    		System.out.println("Stack is Empty.");
    	}
    	else
    	{
	    	count--;//changes position of count to one back
	    	data = stack[count];
	    	stack[count] = 0.0;//resets element to zero
    	}
    	return data;
    }
    /**
     *returns count of stack but makes no changes 
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
			data = stack[count-1];
    	}    	
		return data;		
    }
    /**
     *prints entire stack
     */
    protected void show()
    {
    	System.out.print("Stack ");
        for(int n = 0 ; n < stack.length ; n++)
    	{
    		System.out.print(stack[n] + "|");
    	}    	
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
