import java.io.Serializable;
/**
 *
 * @author Caio Marteli
 * Code adapted from geeksforgeeks (2021) web source code (Version 1.0) [Source code]. https://www.geeksforgeeks.org/max-heap-in-java/
 * Some methods previously submitted for DSA SEM2 - Modified and improved October 2021
 */
public class DSAMaxHeap implements Serializable{
	/************************************************************
	 Java program to implement Max Heap
	************************************************************/
	private int[] Heap;
    private int size;
    private int maxsize;
	/************************************************************
    Default Constructor:
    IMPORT: maxsize (int)
    EXPORT: Address of a new DSAMaxHeap object
    ASSERTION: initializes an empty max heap with given maximum
    capacity
    ************************************************************/
	public DSAMaxHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize];
	}

	/************************************************************
    IMPORT: pos (int)
    EXPORT: integer
    ASSERTION: Returns position of parent
    ************************************************************/
    private int parent(int pos)
	{
		return(pos - 1) / 2;
	}

	/************************************************************
    IMPORT: pos (int)
    EXPORT: integer
    ASSERTION: Returning left children
    ************************************************************/
    private int leftChild(int pos)
	{
		return (2 * pos) + 1;
	}

	/************************************************************
    IMPORT: pos (int)
    EXPORT: integer
    ASSERTION: Returning right children
    ************************************************************/
    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }

	/************************************************************
    IMPORT: pos (int)
    EXPORT: boolean
    ASSERTION: Returning true of given node is leaf
    ************************************************************/
    private boolean isLeaf(int pos)
    {
        if(pos > (size / 2) && pos <= size)
		{
            return true;
        }
        return false;
    }

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: swap helper method
    ************************************************************/
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    /************************************************************
    IMPORT: pos (int) //node to heapify
    EXPORT:
    ASSERTION: Recursive function to max heapify given subtree
    ************************************************************/
    private void maxHeapify(int pos)
    {
        if(!isLeaf(pos)) //if the node has children
        {
            //check if current node is lower than it's children
            if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)])
            {
                if(Heap[leftChild(pos)] > Heap[rightChild(pos)]) // if left child is > right
                {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }

    }


	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Inserts a new element to max heap
    ************************************************************/
    public void insert(int element)
    {
        Heap[size] = element;

        // tickle up and fix heap
        int current = size;
        while(Heap[current] > Heap[parent(current)])
        {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Remove an element from max heap
    ************************************************************/
    public int extractMax()
    {
        if(size != 0)
        {
            int popped = Heap[0]; //stores old root
            Heap[0] = Heap[size--]; //grabs last element from array
            maxHeapify(0);
            return popped;
        }
        else
        {
            throw new IllegalArgumentException("Heap is empty");
        }
    }

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: To display heap
    ************************************************************/
    public void print()
    {
        for(int i = 0; i <= size / 2; i++)
        {
            System.out.println(" PARENT : |" + Heap[i]
                + "| LEFT CHILD : |" + Heap[2 * i + 1]
                + "| RIGHT CHILD : |" + Heap[2 * i + 2]);
        }
    }

}//end DSAMaxHeap class