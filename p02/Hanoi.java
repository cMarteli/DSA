import java.util.*;




/**
 *
 * @author Caio Marteli
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        //Initialize variables
        int diskNum = 1;
        System.out.println("**Testing Tower of Hanoi method**");
        diskNum = (checkInteger("Enter number of disks:"));

        towers(diskNum, 'A', 'C', 'B', " ");


    }//end main


    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Move n disks from peg src to peg dest
    ************************************************************/
    public static void towers(int n, char src, char dest, char aux, String spaces)
    {
        spaces += ">"; //visualization of every recursive call
        if (n == 1)
        {
            //moveDisk(src, dest, numOfMoves); //Base case: move one disk from peg src to peg dest
            System.out.println(spaces + "Move disk 1 from peg " + src + " to peg " + dest);
        }
        else
        {
            towers(n-1, src, aux, dest, spaces); //Move all but bottom disk to temp peg tmp, This is a smaller (n-1) version of the current problem
            System.out.println(spaces +"Move disk " + n + " from peg " + src + " to peg " + dest);
            towers(n-1, aux, dest, src, spaces); //Move the rest from temp peg tmp to target peg dest
        }


    }


    /*******ERROR HANDLING METHODS*******************************/
    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Gets user integer and repeats until it's a valid input
    ************************************************************/
    public static int checkInteger(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        int userInt = 0;
        String error = "(Invalid Input)\n";
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
            System.out.println("Number of disks cannot be negative"); //Could use throw new IllegalArgumentException but would stop runtime
        }

        return isNeg;
    }



}