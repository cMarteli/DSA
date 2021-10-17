import java.io.Serializable;
import java.util.Iterator;

/**
 * DSAStack.java
 * Implementing DSALinkedList
 * @author Caio Marteli 19598552
 */
// Marteli, C (2021) DSAPrac4 source code (Version 2.0) [Source code]. https://github.com/cMarteli/DSA
// previously submitted for DSAPrac4 Modified and improved October 2021 for gameofcatz.java
public class DSAStack implements Iterable, Serializable{

	private DSALinkedList stack;

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSAStack object
    ASSERTION: creates new DSALinkedList
    ************************************************************/
    public DSAStack()
	{
        stack = new DSALinkedList();
	}

    /************************************************************
    IMPORT: data (Object)
    EXPORT: none
    ASSERTION: Adds new element to last position of stack.
    ************************************************************/
    public void push(Object data)
    {
        stack.insertFirst(data);
    }

    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Removes element last added to stack
    ************************************************************/
    public Object pop()
    {
        Object data = null;
        try {
            data = stack.removeFirst();
            //stack.peekFirst();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Nothing left in stack");
        }
        return data;
    }

    /************************************************************
    IMPORT: none
    EXPORT: (Object)
    ASSERTION: Returns top of stack but makes no changes
    ************************************************************/
    public Object peek()
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
    public Iterator iterator()
    {
        return stack.iterator();
    }
}
