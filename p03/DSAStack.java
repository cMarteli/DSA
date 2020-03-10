import java.util.Stack;
/**
 *
 * @author Caio Marteli
 */
public class DSAStack {

	protected int DEFAULT_CAPACITY = 5;
	protected Object stack[];
	protected int count; //keeps index of last element in stack
    protected int rear;//rear position of Circular queue(new element enqueued at rear).
    protected int front; //front position of Circular queue(element will be dequeued from front).

	/*
    * Default Constructor
	*/
    public DSAStack()
	{
		stack = new Object[DEFAULT_CAPACITY];
		count = 0;
	}
	/**
     * Alternate Constructor
	 */
    public DSAStack(int maxCapacity)
	{
		stack = new Object[maxCapacity];
		count = 0;
	}
	/**
     * adds new element to last position of stack.
     */
    public void push(Object data)
    {
    	stack[count] = data;
    	count++;
    }

    /**
     * removes element last added to stack
     */
    public Object pop()
    {
    	Object data = null;
    	if (isEmpty())
    	{
            throw new IllegalArgumentException("Stack is Empty.");
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
    public Object peek()
    {
    	Object data = null;
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
    public void show()
    {
    	System.out.print("Stack ");
        for(int n = 0 ; n < stack.length ; n++)
    	{
    		System.out.print(stack[n] + "|");
    	}    	
    }

    public boolean isEmpty()
    {
    	boolean pass = false;    	
    	if(count == 0)
    	{
    		pass = true;
    	}
    	return pass;
    }

}
