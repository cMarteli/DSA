/**
 * DSAStack.java
 * @author Caio Marteli 19598552
 */
public class DSAStack {

	protected Object stack[];
	protected int count; //keeps index of last element in stack
    /************************************************************
    CONSTRUCTOR:
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
    	if (isEmpty())
    	{
            throw new IllegalArgumentException("Stack is Empty.");
    	}
    	else
    	{
            Object data = stack[count-1]; //stores object to pop
	    	stack[count-1] = null; //deletes top of stack
            count--; //moves count back by one
            return data;
    	}

    }

    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Returns top of stack but makes no changes
    ************************************************************/
    public Object peek()
    {
    	if (isEmpty())
    	{
    		throw new IllegalArgumentException("Stack is Empty.");
    	}
    	else
    	{
		    return stack[count-1];
    	}
    }

    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire stack
    ************************************************************/
    public void show()
    {
        if(!isEmpty())
        {
            System.out.print("Printing Stack:");
            for(int n = 0 ; n < count ; n++)
            {
                System.out.print(stack[n] + "|");
            }
        }
        else
        {
            System.out.println("Stack is empty");
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
