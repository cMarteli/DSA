import java.util.Stack;
/**
 * EquationSolver.java
 * @author Caio Marteli 19598552
 * Takes input in Infix converts to postfix and solves
 */
public class EquationSolverTestHarness {

    /************************************************************ 
    ASSERTION: Test Harness for Equation Solver
    ************************************************************/ 
    public static void main(String[] args)
    {
        EquationSolver eq = new EquationSolver();

        //test1
        System.out.println("TEST 1");
        String test1 = eq.infixToPostfix("3+3*8-9/3*8"); //testing infix to postfix
        System.out.println("Testing Equation: 3+3*8-9/3*8 \nExpected postfix: 338*+93/8*-\nReturned: "+ test1);
        System.out.println("Expected Solution: 3\nReturned:" + eq.evaluatePostfix(test1)); // testing evaluate method

        //test2
        System.out.println("TEST 2");
        String test2 = eq.infixToPostfix("9*2*8+4/3+7*6-3"); //testing infix to postfix
        System.out.println("Testing Equation: 9*2*8+4/3+7*6-3 \nExpected postfix: 92*8*43/+76*+3-\nReturned: "+ test2); 
        System.out.println("Expected Solution: ~184\nReturned:" + eq.evaluatePostfix(test2)); // testing evaluate method

    }

}