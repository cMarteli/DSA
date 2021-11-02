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

    // quickSort - front-end for kick-starting the recursive algorithm
    // adapted from
    // geeksforgeeks source code (Version 2.0) [Web code]. https://www.geeksforgeeks.org/quick-sort/
    public static void quickSort(int[] A)
    {
        quickSortRecurse(A, 0, A.length-1);
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {

        if (leftIdx < rightIdx)
        {
            /* pi is partitioning index, arr[pi] is
                now at right place */
            int pivot = A[rightIdx]; //chooses pivot
            //int pivot = A[medianOfThree(A)]; //chooses pivot
            int pi = doPartitioning(A, leftIdx, rightIdx, pivot);

            // Recursively sort elements before
            // partition and after partition
            quickSortRecurse(A, leftIdx, pi-1);
            quickSortRecurse(A, pi+1, rightIdx);

        }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        int i = (leftIdx-1); // index of smaller element
        for (int j=leftIdx; j < rightIdx; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (A[j] <= pivotIdx)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = A[i+1];
        A[i+1] = A[rightIdx];
        A[rightIdx] = temp;

        return i+1;
    }//doPartitioning

    public static int medianOfThree(int[] A)
    {
        // int left = 0;
        // int mid = (A.length-1)/2;
        // int right = A.length-1;
        return A.length-1;
        // if((A[left] < A[mid] || A[left] < A[right]) && (A[left] > A[mid] || A[left] > A[right])){
        //     return left;
        // }
        // else if((A[mid] < A[left] || A[mid] < A[right]) && (A[mid] > A[left] || A[mid] > A[right])){
        //     return mid;
        // }
        // else{
        //     return right;
        // }
    }


}//end Sorts calss
