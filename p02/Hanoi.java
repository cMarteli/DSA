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

        towers(diskNum, 1, 3, 0);


    }//end main


    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Move n disks from peg src to peg dest
    ************************************************************/
    public static void moveDisk(int src, int dest, int numOfMoves)
    {
        for(int i = 0; i < numOfMoves; i++)
        {
            System.out.print("   ");//prints 3 spaces for every recursion
        }       
        System.out.println("Moving  top  disk  from  peg  " + src + "  to  peg " + dest);        
    }

    /************************************************************
    IMPORT: prompt (String)
    EXPORT: userInt (integer)
    ASSERTION: Move n disks from peg src to peg dest
    ************************************************************/
    public static void towers(int n, int src, int dest, int numOfMoves)
    {        
        numOfMoves++;
        int tmp = 0;        

        if (n == 1)
        {
            moveDisk(src, dest, numOfMoves); //Base case: move one disk from peg src to peg dest
        }
        else
        {
            tmp = 6 - src - dest; //tmp is the ‘other’ (non-target) peg, since src+dest+tmp = 6

            towers(n-1, src, tmp, numOfMoves); //Move all but bottom disk to temp peg tmp, This is a smaller (n-1) version of the current problem
        
            moveDisk(src, dest, numOfMoves); //Move bottom disk to target peg dest
        
            towers(n-1, tmp, dest, numOfMoves); //Move the rest from temp peg tmp to target peg dest        
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