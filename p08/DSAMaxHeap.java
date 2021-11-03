import java.io.Serializable;
/**
 *
 * @author Caio Marteli
 * // adapted from geeksforgeeks (2021) web source code (Version 1.0) [Source code]. https://www.geeksforgeeks.org/max-heap-in-java/
 *  Some methods previously submitted for OOPD final assignment Modified and improved October 2021 for gameofcatz.java
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
    IMPORT: none
    EXPORT:
    ASSERTION: initializes an empty max heap with given maximum
    capacity
    ************************************************************/
	public DSAMaxHeap(int maxsize)
	{
		// This keyword refers to current instance itself
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize];
	}

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Returns position of parent
    ************************************************************/
    private int parent(int pos)
	{
		return (pos - 1) / 2;
	}

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Returning left children
    ************************************************************/
    private int leftChild(int pos)
	{
		return (2 * pos) + 1;
	}

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Returning right children
    ************************************************************/
    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }

	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Returning true of given node is leaf
    ************************************************************/
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size)
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
        if (isLeaf(pos))
        {
        return;
        }
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) //if current node is lower than it's children
            {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) // if left child is > right
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


	/************************************************************
    IMPORT: none
    EXPORT:
    ASSERTION: Inserts a new element to max heap
    ************************************************************/
    public void insert(int element)
    {
        Heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)])
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
        for (int i = 0; i <= size / 2; i++)
        {
            System.out.println(" PARENT : |" + Heap[i]
                + "| LEFT CHILD : |" + Heap[2 * i + 1]
                + "| RIGHT CHILD : |" + Heap[2 * i + 2]);
        }
    }

}//end DSAMaxHeap class