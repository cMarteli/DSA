/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    /*
        Bubble sort - Checks two adjacent elements in an array swaps them if in wrong order then repeats it until it's done.
    */
    public static void bubbleSort(int[] A)
    {
        for(int pass = 0; pass < A.length-1; pass++)
        {
            for(int ii = 0; ii < (A.length-1 - pass) ; ii++)
            {
                if(A[ii] > A[ii+1])
                {
                    int temp = A[ii];
                    A[ii] = A[ii+1];
                    A[ii+1] = temp; 
                }
            }            
        }
    }// bubbleSort()

    /*
        Selection sort - Finds the smallest element in array first,
        inserts it in the first position then checks the remaining elements
        and puts smallest in next position and so on.
    */
    public static void selectionSort(int[] A)
    {
        for(int nn = 0; nn < A.length-1; nn++)
        {
            int minIdx = nn;
            for(int jj = nn + 1; jj < A.length-1; jj++)
            {
                if(A[jj] < A[minIdx])
                {
                    minIdx = jj;
                }
            }          
            int temp = A[minIdx];
            A[minIdx] = A[nn];
            A[nn] = temp;
        }
        
    }// selectionSort()

    /*
        Insertion sort - Constantly attempts to place the current element in
        the right order, one by one.
    */
    public static void insertionSort(int[] A)
    {
        for(int nn = 1; nn < A.length-1; nn++)
        {
            int ii = nn;
            while(ii > 0 && A[ii-1] > A[ii])
            {
                int temp = A[ii];
                A[ii] = A[ii-1];
                A[ii-1] = temp;
            }
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
