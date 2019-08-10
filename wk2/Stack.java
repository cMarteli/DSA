
/**
 *
 * @author Caio Marteli
 */
public class Stack {

	int stack[] = new int[5];
	int top = 0; //keeps index of last element in stack

	//adds new element to last position of stack.
    public void push(int data)
    {
    	stack[top] = data;
    	top++;
    }

    //removes element last added to stack
    public int pop()
    {
    	int data;
    	top--;//changes position of top to one back
    	data = stack[top];
    	stack[top] = 0;//resets element to zero
    	return data;
    }
    //returns top of stack but makes no changes 
    public int peek()
    {
		int data;
		data = stack[top-1];
		return data;
    }
    //reads entire stack
    public void show()
    {
    	for(int n : stack)
    	{
    		System.out.print(n + " ");
    	}    	
    }

}
