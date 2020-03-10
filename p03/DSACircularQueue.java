import java.util.Arrays;
/**
 *
 * @author Caio Marteli
 */
public class DSACircularQueue extends DSAQueue{     

    /**
     * Default constructor.
     */
    protected DSACircularQueue() 
    {
        super();        
        front = -1;
        rear = -1;
    }
     /**
     * Alternate constructor.
     */
    protected DSACircularQueue(int maxSize) 
    {
        super();        
        front = -1;
        rear = -1;
    }

    /**
     * Enqueue elements to rear.
     */
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

    /**
     * Dequeue element from Front.
     */
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
        System.out.print("Displaying circular ");
        super.show();        
    }

}