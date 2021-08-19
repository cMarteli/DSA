import java.util.*;




/**
 *
 * @author Caio Marteli
 */
public class GDCnBase {

    /**
     * @param args the command line arguments
     */
    
    //global static array to aid with hex conversion
    private static char symbols[] = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION: Recursive method to calculate the greatest common divisor of two numbers.
    NOTE! No noticeable slowdown on tested hardware for entire integer range (2147483647)
    ************************************************************/
    public int gcd(int n1, int n2)
    {        
        int result = 0;

        if(n2 != 0)
        {
            result = gcd(n2, n1 % n2); // recursive call
        }
        else
        {
            result = (n1);
        }
        return result;        
    }

    /************************************************************
    IMPORT: n (Integer)
    EXPORT:(Integer)
    ASSERTION: Recursive methods to change a decimal integer to any base up to 16.
    NOTE! No noticeable slowdown on tested hardware for entire integer range (2147483647)
    ************************************************************/
    public String cBase (int n, int base)
    {
        return cBase(n, base, 0, "");
    }

    private String cBase (int n, int base, int position, String result)
    {
        if (n < Math.pow(base, position + 1) )
        {
            return symbols[(n / (int)Math.pow(base, position))] + result;
        }
        else
        {
            int remainder = (n % (int)Math.pow(base, position + 1));
            return cBase (n - remainder, base, position + 1, symbols[remainder / (int)(Math.pow(base, position))] + result);
        }
    }

}