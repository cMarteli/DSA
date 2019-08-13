import java.util.Arrays;
/**
 *
 * @author Caio Marteli
 */
public class DSACircularQueue {
    protected int DEFAULT_CAPACITY = 5;
    protected int currentSize; //Current Circular Queue Size
    protected double[] queue;
    protected int maxSize; //Circular Queue maximum size

    protected int rear;//rear position of Circular queue(new element enqueued at rear).
    protected int front; //front position of Circular queue(element will be dequeued from front).      

    protected DSACircularQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = (double[]) new double[this.maxSize];
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
            System.out.println("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % queue.length;
            queue[rear] = item;
            currentSize++;
            
            if (front == -1) {
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
            System.out.println("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            data = queue[front];
            queue[front] = 0.0;
            front = (front + 1) % queue.length;
            currentSize--;
        }
        return data;
    }

    /**
     * Check if queue is full.
     */
    protected boolean isFull() 
    {
        return (currentSize == queue.length);
    }

    /**
     * Check if Queue is empty.
     */
    protected boolean isEmpty() 
    {
        return (currentSize == 0);
    }

    protected void show() 
    {
        System.out.println("CircularQueue [" + Arrays.toString(queue) + "]");
    }

}