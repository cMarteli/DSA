import java.util.*;




/**
 *
 * @author Caio Marteli
 */
public class FactnFib {

    /**
     * @param args the command line arguments
     */
    
    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Long)
    ASSERTION: Recursive method to calculate factorial.
    NOTE! Overflows into the negatives starting at n = 21 due to long datatype max size performant until then
    ************************************************************/
    public long factorial(int n)
    {        
        long result = 0;

        if(n == 0)
        {
            result = 1;
        }
        else
        {
            result = n* factorial(n-1); //recursive call
        }

        return result;    
    }


    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION: Recursive method to calculate the nth fibonacci number.
    NOTE! Slowdowns after n = 38 with more pronounced slowdowns at n = 40+
    ************************************************************/
    public int fibonacci(int n)
    {        
        int result = 0;

        if(n == 0)
        {
            result = 0;
        }
        else if(n == 1)
        {
            result = 1;
        }
        else
        {
            result = fibonacci(n-1) + fibonacci(n-2); //two recursive calls!
        }

        return result;        
    }

}