import java.util.Arrays;
/**
 * DSACircularQueue.java
 * @author Caio Marteli 19598552
 */
public class DSACircularQueue extends DSAQueue{     

    /************************************************************
    Default Constructor:
    IMPORT: none
    EXPORT: address of new DSACircularQueue object
    ASSERTION: front = -1 and rear = -1 are default states
    ************************************************************/
    protected DSACircularQueue() 
    {
        super();        
        front = -1;
        rear = -1;
    }
    /************************************************************
    OVERLOADED CONSTRUCTOR:
    IMPORT: maxSize (integer)
    EXPORT: address of new DSACircularQueue object
    ASSERTION: imports maxSize passes it to parent class contructor
    ************************************************************/
    protected DSACircularQueue(int maxSize) 
    {
        super();        
        front = -1;
        rear = -1;
    }

    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Enqueue elements to rear.
    ************************************************************/
    protected void enqueue(double data)
        {
        if (isFull()) 
        {
            System.out.println("Circular Queue is full.");
        }
        else 
        {
            rear = (rear + 1) % queue.length;
            queue[rear] = data;
            currentSize++;
            
            if (front == -1) 
            {
				front = rear;
			}            
            System.out.println(data +" Added to queue.");
        }
    }

    /************************************************************
    IMPORT: none
    EXPORT: (real)
    ASSERTION: Dequeue element from Front.
    ************************************************************/
    protected double dequeue()
        {
        double data = queue[front];
        if (isEmpty()) 
        {
            System.out.println("Circular Queue is empty.");
        }
        else 
        {            
            queue[front] = 0.0;
            front = (front + 1) % queue.length;
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
        System.out.print("Displaying circular ");
        super.show();        
    }

}