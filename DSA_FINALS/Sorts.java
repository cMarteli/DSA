/**
** Software Technology 152
** Class to hold various static sort methods.
** Sorting algorithm Code adapted from:
** geeksforgeeks source code (Version 2.0) [Web code]. https://www.geeksforgeeks.org/
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
    // adapted from
    // geeksforgeeks source code (Version 2.0) [Web code]. https://www.geeksforgeeks.org/merge-sort/
    public static void mergeSort(int[] A)
    {
        mergeSortRecurse(A, 0, A.length-1);
    }//mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        if (leftIdx < rightIdx)
        {
            // Find the middle point
            int midIdx = leftIdx + ((rightIdx-leftIdx)/2);

            // Sort first and second halves
            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx + 1, rightIdx);

            // Merge the sorted halves
            merge(A, leftIdx, midIdx, rightIdx);
        }

    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
                // Find sizes of two subarrays to be merged
                int n1 = midIdx - leftIdx + 1;
                int n2 = rightIdx - midIdx;

                /* Create temp arrays */
                int L[] = new int[n1];
                int R[] = new int[n2];

                /*Copy data to temp arrays*/
                for (int i = 0; i < n1; ++i)
                    L[i] = A[leftIdx + i];
                for (int j = 0; j < n2; ++j)
                    R[j] = A[midIdx + 1 + j];

                /* Merge the temp arrays */

                // Initial indexes of first and second subarrays
                int i = 0, j = 0;

                // Initial index of merged subarray array
                int k = leftIdx;
                while (i < n1 && j < n2) {
                    if (L[i] <= R[j]) {
                        A[k] = L[i];
                        i++;
                    }
                    else {
                        A[k] = R[j];
                        j++;
                    }
                    k++;
                }

                /* Copy remaining elements of L[] if any */
                while (i < n1) {
                    A[k] = L[i];
                    i++;
                    k++;
                }

                /* Copy remaining elements of R[] if any */
                while (j < n2) {
                    A[k] = R[j];
                    j++;
                    k++;
                }
    }//merge()

    // quickSort med of 3 - front-end for kick-starting the recursive algorithm
    // adapted from
    // linuxhint source code (Version 2.0) [Web code]. https://linuxhint.com/quick-sort-java-explained/
    public static void quickSort(int[] A)
    {
        quickSortRecurse(A, 0, A.length-1);
    }//quickSort()

    private static void quickSortRecurse(int arr[], int low, int high) {
        if (low < high) {
            pivot(arr, low, high);
            int p = partition(arr, low, high);
            quickSortRecurse(arr, low, p - 1);
            quickSortRecurse(arr, p + 1, high);
        }
    }//quickSortRecurse()

    private static int partition(int A[], int low, int high) {
        int pivot = A[high];
        int i = low;
        int j = high;
        do {
            do {
                ++i;
            } while(A[i] < pivot);
            do {
                --j;
            } while (A[j] > pivot);
            if (i < j)
            {
                swap(A, i, j);
            }
        } while (i < j);
        swap (A, i, high);
        return i;
    }

    public static void pivot(int A[], int low, int high)
    {
        int mid = (low + high) / 2;
        if (A[mid] < A[low])
        {
            swap(A, low, mid);
        }
        if (A[high] < A[low])
        {
            swap(A, low, high);
        }
        if ((high - low) > 2)
        {
            if (A[mid] < A[high])
            {
                swap (A, mid, high);
            }
        }
    }

    public static void swap (int A[], int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }


}//end Sorts calss
