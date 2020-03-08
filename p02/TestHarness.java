import java.util.*;




/**
 *
 * @author Caio Marteli
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //Initialize variables
        FactnFib fb = new FactnFib();
        GDCnBase gb = new GDCnBase();

        int userFactorial = 0, userFibbonaci = 0, gcd1 = 0, gcd2 =0, number = 0, base = 0;


        //Testing factorial method
        System.out.println("**Testing factorial method**");
        userFactorial = (checkInteger("Enter number:"));
        System.out.println("Result is " + fb.factorial(userFactorial));        

        //testing fibonnaci method
        System.out.println("**Testing fibonnaci method**");
        userFibbonaci = (checkInteger("Enter number:"));
        System.out.println("Result is " + fb.fibonacci(userFibbonaci));        

        //testing greatest common divisor
        System.out.println("**Testing GCD method** [2 numbers:]");
        gcd1 = (checkInteger("Enter first number:"));
        gcd2 = (checkInteger("Enter second number:"));
        System.out.println("Result is " + gb.gcd(gcd1, gcd2));

        //testing base converter
        System.out.println("**Testing Base Converter method** [2 numbers:]");
        number = (checkInteger("Enter number to convert:"));        
        while(base == 0 || base > 16) //Makes sure it's a valid base
        {
            base = (checkInteger("Enter base: [1-16]"));
        }        
        System.out.println("Result is " + gb.cBase(number, base));


    }//end main


    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Gets user integer and repeats until it's a valid input
    ************************************************************/
    public static int checkInteger(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        int userInt = 0;
        String error = "(Invalid Integer)\n";
        String outStr = prompt;
        boolean isValid = false;
        
        while (isValid == false || isNegative(userInt))
        {
            try
            {
                System.out.println(outStr);
                outStr = error + prompt;
                userInt = sc.nextInt();
                isValid = true;
            }
            catch(InputMismatchException e) 
            {
                System.out.print(error);
                sc = new Scanner(System.in);
                userInt = 0;
                outStr = prompt;
                isValid = false;
            }
        }

        return userInt;
    }

    /************************************************************
    IMPORT: n (integer)
    EXPORT: isNeg (boolean)
    ASSERTION: Checks if an integer is negative
    ************************************************************/
    public static boolean isNegative(int n)
    {
        boolean isNeg = false;

        if(n >= 0)
        {
            isNeg = false;

        }
        else
        {
            isNeg = true;
            System.out.println("Integer cannot be negative");
        }

        return isNeg;
    }

}
