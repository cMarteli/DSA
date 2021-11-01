import java.util.Scanner;

/**
 *
 * @author Caio Marteli
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        MockTest test = new MockTest();
        int input[] = {5, 10, 20, 30, 40};

        System.out.println("** TESTING Iterative Fib **");
        for(int in : input)
        {
            System.out.println("Input: " + in);
            long startTime = System.nanoTime();
            test.fibonacci2(in); //tested method
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds

            System.out.println("time taken: " + duration + "ns");
        }

        System.out.println("** TESTING recursive Fib **");
        for(int in : input)
        {
            System.out.println("Input: " + in);
            long startTime = System.nanoTime();
            test.fibonacci(in); //tested method
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds

            System.out.println("time taken: " + duration + "ns");
        }

        System.out.println("** TESTING fibFact **");
        for(int in : input)
        {
            System.out.println("Input: " + in);
            long startTime = System.nanoTime();
            test.factFib(in); //tested method
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds

            System.out.println("time taken: " + duration + "ns");
        }

        System.out.println("** TESTING fib3 **");
        for(int in : input)
        {
            System.out.println("Input: " + in);
            long startTime = System.nanoTime();
            test.fib3(in); //tested method
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds

            System.out.println("time taken: " + duration + "ns");
        }




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
            catch(Exception e)
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
            System.out.println("Integer cannot be negative"); //Could use throw new IllegalArgumentException but would stop runtime
        }

        return isNeg;
    }

}