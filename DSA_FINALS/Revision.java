/***
* DSA Revision - Code
*
***/

/***
** SORTS **
***/

//O(N^2)

// bubble sort
public static int[] bubbleSort(int[] A)
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
    return A;
}//bubbleSort()

// selection sort
public static int[] selectionSort(int[] A)
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
    return A;
    
}// selectionSort()

// insertion sort
public static int[] insertionSort(int[] A)
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
    return A;
}// insertionSort()

// quick sort
// low can be 0 | high can be arr.length-1
static void quickSort(int[] arr, int low, int high)
{
    if (low < high) 
    {
          
        // pi is partitioning index, arr[p]
        // is now at right place 
        int pi = partition(arr, low, high);
  
        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}


// A utility function to swap two elements
static void swap(int[] arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

static int partition(int[] arr, int low, int high)
{
      
    // pivot
    int pivot = arr[high]; 
      
    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (low - 1); 
  
    for(int j = low; j <= high - 1; j++)
    {
          
        // If current element is smaller 
        // than the pivot
        if (arr[j] < pivot) 
        {
              
            // Increment index of 
            // smaller element
            i++; 
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}