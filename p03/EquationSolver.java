import java.util.Stack;
/**
 * EquationSolver.java
 * @author Caio Marteli 19598552
 * modified: 15/08/2021
 */
public class EquationSolver {


    /************************************************************
    IMPORT: equation (string)
    EXPORT: result (String)
    ASSERTION: Convert  infix-form  equation  into  postfix.
    ************************************************************/ 
    public String infixToPostfix(String equation)
    {
        DSAStack postfixStack = new DSAStack(equation.length()); // Create stack size = length of equation string
        String result = "";
        char currentChar = ' ';
        for (int i = 0; i < equation.length(); i++)
        {
            currentChar = equation.charAt(i);
            //System.out.println("no. in > [" + currentChar + "]");
            if(isOperand(currentChar)) //if current char is operand(number)...
            {
                result = result + currentChar; //...add to result
            }
            else //is operator(+, -, *, /)
            {        
                while(!postfixStack.isEmpty() && hasPrecendence(((char)postfixStack.peek()), currentChar))
                {
                    result = result + (char)postfixStack.pop();
                }
                postfixStack.push(currentChar); //pushes current operand on to stack
                //System.out.println("[" + currentChar + "]" + "pushed onto stack");
            }
            //System.out.println("current result: "+ result);          
        }
        while(!postfixStack.isEmpty()) //pops anything remaining in stack
        {
            result = result + (char)postfixStack.pop();
        }
        
        return result;
    }


    /************************************************************
    IMPORT: inChar (char)
    EXPORT: boolean
    ASSERTION:figures out if operand(number) or operator(sign)
    ************************************************************/ 
    private boolean isOperand(char inChar)
    {
        if (inChar == '/' || inChar == '*' || inChar == '+' || inChar == '-')
        {
            return false;
        }        
        else
        {
            //System.out.println("is number");
            return true;
        }
    }
    /************************************************************
    IMPORT: top (char), currentC (char)
    EXPORT: boolean
    ASSERTION:Helper function for parseInfixToPostfix().
    finds if the first operand has precedence over the second
    ************************************************************/ 
    private boolean hasPrecendence(char top, char currentC)
    {
        if (top == '*' || top == '/')
        {   //top has precedence
            return true;
        }
        else if(top == '+' || top == '-')
        {
            if (currentC == '+' || currentC == '-')
            {   //top has precedence
                return true;
            }
            else if (currentC == '*' || currentC == '/')
            {   //currentC has precedence
                return false;
            }
            else
            {
                throw new IllegalArgumentException("Invalid Operand.");
            }
        }
        else
        {
            throw new IllegalArgumentException("Invalid Operand.");
        }
    }

    /************************************************************
    IMPORT: postfix (String)
    EXPORT: (int)
    ASSERTION: Method to evaluate value of a postfix expression
    ************************************************************/ 
    public int evaluatePostfix(String postfix)
    {
        DSAStack evaluateStack = new DSAStack(postfix.length()); //stack size is length of postfix string

        for(int i = 0; i < postfix.length(); i++) //read through postfix string
        {
            char currentC = postfix.charAt(i);
             
           
            // 
            if(Character.isDigit(currentC)) //if char is operand(number)...
            {
                evaluateStack.push(currentC - '0'); //...push it to the stack. (subtracting '0' from char casts it to int)
            }
            else //else if char is operator. pop twice then evaluate
            {
                int val1 = (int)evaluateStack.pop();
                int val2 = (int)evaluateStack.pop();
                 
                switch(currentC)
                {
                    case '+':
                    evaluateStack.push(val2+val1);
                    break;
                     
                    case '-':
                    evaluateStack.push(val2- val1);
                    break;
                     
                    case '/':
                    evaluateStack.push(val2/val1);
                    break;
                     
                    case '*':
                    evaluateStack.push(val2*val1);
                    break;
                }
            }
        }
        return (int)evaluateStack.pop();   
    }

//end of class
}