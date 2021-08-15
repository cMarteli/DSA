import java.util.Stack;
/**
 * DSAStack.java
 * @author Caio Marteli 19598552
 */
public class DSAStack {

	protected int DEFAULT_CAPACITY = 5;
	protected Object stack[];
	protected int count; //keeps index of last element in stack

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAStack object
    ASSERTION: count = 0 are default states
    ************************************************************/ 
    public DSAStack()
	{
		stack = new Object[DEFAULT_CAPACITY];
		count = 0;
	}
    /************************************************************
    OVERLOADED CONSTRUCTOR:
    IMPORT: maxCapacity (integer)
    EXPORT: address of new DSAStack object
    ASSERTION: imports maxCapacity passes it to parent class contructor
    ************************************************************/
    public DSAStack(int maxCapacity)
	{
		stack = new Object[maxCapacity];
		count = 0;
	}
    
    /************************************************************
    IMPORT: data (real)
    EXPORT: none
    ASSERTION: Adds new element to last position of stack.
    ************************************************************/
    public void push(Object data)
    {
    	stack[count] = data;
    	count++;
    }

    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Removes element last added to stack
    ************************************************************/
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

    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Returns count of stack but makes no changes
    ************************************************************/
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

    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire stack
    ************************************************************/
    public void show()
    {
    	System.out.print("Stack ");
        for(int n = 0 ; n < stack.length ; n++)
    	{
    		System.out.print(stack[n] + "|");
    	}    	
    }

    /************************************************************
    IMPORT: none
    EXPORT: (boolean)
    ASSERTION: Check if stack is empty.
    ************************************************************/

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
