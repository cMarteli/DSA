/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
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
    }//bubbleSort()

    // selection sort
public static void selectionSort(int[] A){  
        for (int i = 0; i < A.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < A.length; j++){  
                if (A[j] < A[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = A[index];   
            A[index] = A[i];  
            A[i] = smallerNumber;  
        }  
    }

    // insertion sort
    public static void insertionSort(int A[]) {  
        int n = A.length;  
        for (int j = 1; j < n; j++) {  
            int key = A[j];  
            int i = j-1;  
            while ( (i > -1) && ( A [i] > key ) ) {  
                A [i+1] = A [i];  
                i--;  
            }  
            A[i+1] = key;  
        }  
    }

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
