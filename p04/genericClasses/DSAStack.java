import java.io.Serializable;
import java.util.Iterator;

/**
 * DSAStack.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
public class DSAStack<T extends Serializable> implements Iterable<T>{

	private DSALinkedList<T> stack;

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAStack object
    ASSERTION: creates new DSALinkedList
    ************************************************************/ 
    public DSAStack()
	{
        stack = new DSALinkedList<T>();
	}
    
    /************************************************************
    IMPORT: data (Object)
    EXPORT: none
    ASSERTION: Adds new element to last position of stack.
    ************************************************************/
    public void push(T data)
    {
        stack.insertFirst(data);
    }

    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Removes element last added to stack
    ************************************************************/
    public T pop()
    {
        T data = null;
        if (stack.isEmpty())
        {
            throw new IllegalArgumentException("Stack is Empty.");
        }
        try {
            data = stack.peekFirst();
            stack.removeFirst();            
        } catch (NullPointerException e) {
            System.out.println("Nothing left in stack");
        }
        return data;
    }

    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Returns top of stack but makes no changes
    ************************************************************/
    public T peek()
    {
		return stack.peekFirst();		
    }

    /************************************************************
    IMPORT: none
    EXPORT: none
    ASSERTION: Prints entire stack
    ************************************************************/
    public void show()
    {
        stack.show();
    }

    /************************************************************
    IMPORT: none
    EXPORT: (boolean)
    ASSERTION: Check if stack is empty.
    ************************************************************/
    public boolean isEmpty()
    {
    	return stack.isEmpty();
    }

    /************************************************************
    IMPORT: none
    EXPORT: iterator
    ASSERTION: Exposes lists iterator
    ************************************************************/
    public Iterator<T> iterator()
    {
        return stack.iterator();
    }
}
