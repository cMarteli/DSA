/**
 *
 *
 * @author Caio Marteli 19598552
 */
public class MockTest
{

    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION: Recursive method to calculate the nth fibonacci number.
    NOTE! Slowdowns after n = 38 with more pronounced slowdowns at n = 40+
    Space complexity: O(n)
    Time complexity: O(n^2)
    ************************************************************/
    public int fibonacci(int n)
    {
        if(n <= 1)
        {
            return n;
        }
        else
        {
            return fibonacci(n-1) + fibonacci(n-2); //two recursive calls!
        }
    }


    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION: Iterative method to calculate the nth fibonacci number.
    NOTE! Much faster than recursive implementation
    Time complexity - O(n)
    Space complexity - O(1)
    ************************************************************/
    public int fibonacci2(int n)
    {
        if(n <= 1)
        {
            return n;
        }
        else
        {
            int result = 1;
		    int prev = 1;

            for(int i = 2; i < n; i++) {
                int temp = result;
                result += prev;
                prev = temp;
            }
            return result;
        }


    }


    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Long)
    ASSERTION: Recursive method to calculate factorial.
    NOTE! Overflows into the negatives starting at n = 21 due to long datatype max size performant until then
    ************************************************************/
    public long factorial(int n)
    {
        if(n == 0)
        {
            return 1;
        }
        else
        {
            return n * factorial(n-1); //recursive call
        }
    }


    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION:
    Time complexity - O(n^2)
    Space complexity - O(1)
    ************************************************************/
    public int factFib(int n)
    {
        if(n == 0)
        {
            return 1;
        }
        else if(n == 1)
        {
            return 2;
        }
        else
        {
            return factFib(n-1) * factFib(n-2); //two recursive calls!
        }
    }


    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION:
    Time complexity - O(n^2)
    Space complexity - O(1)
    ************************************************************/
    public int fib3(int n)
    {
        if(n <= 2)
        {
            return 1;
        }
        else
        {
            return (fib3(n-1) + fib3(n-2) + fib3(n-3)); //two recursive calls!
        }
    }



}