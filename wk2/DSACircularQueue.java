import java.util.Arrays;
/**
 *
 * @author Caio Marteli
 */
public class DSACircularQueue extends DSAQueue{
    protected int rear;//rear position of Circular queue(new element enqueued at rear).
    protected int front; //front position of Circular queue(element will be dequeued from front).      

    /**
     * Default constructor.
     */
    protected DSACircularQueue() 
    {
        queue = (double[]) new double[DEFAULT_CAPACITY];
        currentSize = 0;
        front = -1;
        rear = -1;
    }
     /**
     * Alternate constructor.
     */
    protected DSACircularQueue(int maxSize) 
    {
        queue = (double[]) new double[maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    /**
     * Enqueue elements to rear.
     */
    protected void enqueue(double item)
        {
        if (isFull()) 
        {
            System.out.println("Circular Queue is full.");
        }
        else 
        {
            rear = (rear + 1) % queue.length;
            queue[rear] = item;
            currentSize++;
            
            if (front == -1) 
            {
				front = rear;
			}
        }
    }

    /**
     * Dequeue element from Front.
     */
    protected double dequeue()
        {
        double data = 0.0;
        if (isEmpty()) 
        {
            System.out.println("Circular Queue is empty.");
        }
        else 
        {
            data = queue[front];
            queue[front] = 0.0;
            front = (front + 1) % queue.length;
            currentSize--;
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
        System.out.print("Circular ");
        super.show();        
    }

}