import java.util.Scanner;
import java.util.Arrays;




/**
 *
 * @author Caio Marteli
 */
public class FileSorter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize variables

    String fileName = "RandomNames7000.csv";

    String[] arrayOfStudents = FileReader.readFile(fileName);

    //array with only id numbers
    int[] arrayOfIDs = new int[arrayOfStudents.length];

    for(int i = 0; i < arrayOfStudents.length; i++)
    {
        arrayOfIDs[i] = FileReader.processId(arrayOfStudents[i]);
    }
    //Print Original Unsorted
    printArray(arrayOfStudents);

    //sorts using bubble and writes to file
    FileReader.writeFile("bubbleSorted.csv",convertArray(bubbleSort(arrayOfIDs)));

    //sorts using selection and writes to file
    FileReader.writeFile("selectionSorted.csv",convertArray(selectionSort(arrayOfIDs)));

    //sorts using insertion and writes to file
    FileReader.writeFile("insertionSorted.csv",convertArray(insertionSort(arrayOfIDs)));



    }//end main

    //PRINTING METHODS

    public static void printArray(int inArray[])
    {
    for(int i = 0; i < inArray.length; i++)
        {
            System.out.println(inArray[i]);
        }
    }

    public static void printArray(String inArray[])
    {
    for(int i = 0; i < inArray.length; i++)
        {
            System.out.println(inArray[i]);
        }
    }

    //convert int[] to String[]
    public static String[] convertArray(int[] inArray)
    {
        String strArray[] = new String[inArray.length];

        for(int i = 0; i < inArray.length; i++)
        {
            strArray[i] = String.valueOf(inArray[i]);
        }

        return strArray;
    }

    //SORTS!!!

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
    

}
