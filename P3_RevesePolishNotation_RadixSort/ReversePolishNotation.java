package P3_RevesePolishNotation_RadixSort;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReversePolishNotation 
{
	static Scanner sc = new Scanner(System.in);
	
	public static String convertRPN(String str) 
	{
		Deque<String> operatorStack = new ArrayDeque<>();
		Deque<String> finalQueue = new ArrayDeque<>();
		String[] inputStr = str.split(" ");
		String postFixedForm = "";
		
		for (int i = 0; i < inputStr.length; i++)
		{
			String token = inputStr[i];
			if (isNumber(token))
			{
				finalQueue.addLast(token);
			} else if (isOperator(token))
			{
				String op1 = token;
				while (!operatorStack.isEmpty() &&  
					  (!operatorStack.peek().equals("(") && 
					  (precedence(op1) < precedence(operatorStack.peek()) || precedence(op1) == precedence(operatorStack.peek()) 
					  && hasAsociativityLeft(operatorStack.peek()))))  
				{	
					finalQueue.addLast(operatorStack.poll());
				}
				operatorStack.push(op1);	
			} else if (token.equals("(")) 
			{
				operatorStack.push(token);
			} else if (token.equals(")")) 
			{
				while (!operatorStack.peek().equals("(")) 
				{
					finalQueue.add(operatorStack.pop());
				}
				if (operatorStack.isEmpty()) {
					throw new NoSuchElementException("Did not found correct bracket in stack");
				} 
				operatorStack.pop();
			}
		}
		while (!operatorStack.isEmpty()) 
		{
			String op = operatorStack.pop();
			if (op.equals("(")) 
			{
				throw new NoSuchElementException("Wrong parentheses in expresion!");
			} else 
			{
				finalQueue.addLast(op);
			}
		}
		while (!finalQueue.isEmpty()) 
		{
			postFixedForm += finalQueue.removeFirst() + " ";
		}
		return postFixedForm;
	}
	
	public static int precedence(String str) 
	{
		int result = 13;
		if (str.equals("+") || str.equals("-")) 
		{
			result = 11;
		} else if (str.equals("*") || str.equals("/")) 
		{
			result = 12;
		} 
//			else if (str.equals("^")) {
//			result = 13;
//		}
		return result;
	}
	
	public static boolean hasAsociativityLeft (String str) 
	{
		boolean result = true;
		
		if (str.equals("^")) 
		{
			result = false;
		}
		return result;
	}
	
    public static int evalRPN(String str) 
    {
    	String[] tokens = str.split(" ");
        Deque<Integer> operandsStack = new ArrayDeque<>();
        int op1;
        int op2;
        int result = 0;
        for (int i = 0; i < tokens.length; i++) 
        {
        	if (isNumber(tokens[i])) 
        	{
        		operandsStack.push(Integer.valueOf(tokens[i]));
        	}
        	else 
        	{
        		switch (tokens[i]) 
        		{
        		case "+": 
        			op1 = operandsStack.pop();
        			op2 = operandsStack.pop();
        			result = op2 + op1;
        			break;
        		case "-":
        			op1 = operandsStack.pop();
        			op2 = operandsStack.pop();
        			result = op2 - op1;
        			break;
        		case "*":
        			op1 = operandsStack.pop();
        			op2 = operandsStack.pop();
        			result = op2 * op1;
        			break;
        		case "/":
        			op1 = operandsStack.pop();
        			op2 = operandsStack.pop();
        			result = op2 / op1;
        			break;
        		case "^":
        			op1 = operandsStack.pop();
        			op2 = operandsStack.pop();
        			result = power(op2,op1);
        		}
        		operandsStack.push(result);
        	}
        }
        return operandsStack.pop();
    }
    
    public static int power(int base, int exp) 
    {
    	int result = 1;
    	for (int i = 1; i<=exp; i++) 
    	{
    		result *= base;
    	}
    	return result;
    }
    
    public static boolean isNumber(String string) 
    {
    	char[] charArray = string.toCharArray();
    	int stringLength = string.length();
    	for (int i = 0; i<charArray.length; i++) 
    	{
    		if (charArray[0] == '-' ) 
    		{
    			if (stringLength > 1) 
    			{
    				i++;
    			}
    			else 
    			{
    				return false;
    			}
    		} else 
    		if (!Character.isDigit(charArray[i])) 
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void printStack(Deque<Integer> stack) 
    {
    	while (!stack.isEmpty()) 
    	{
    		System.out.println(stack.poll());
    	}
    }
    
    public static boolean isOperator(String str) 
    {
    	if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^")) 
    	{
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) 
    {
    	String expression = "3 + ( 2 + 1 ) * 2 ^ 3 ^ 2 - 8 / ( 5 - 1 * 2 / 2 )";
    	
    	String convertedExpression = convertRPN(expression);
    	
    	System.out.println("Expression: " + expression + " was converted to: " + convertedExpression + ". (Correct is: 3 2 1 + 2 3 2 ^ ^ * + 8 5 1 2 * 2 / - / -)");
    	System.out.println("==========================");
    	System.out.println("Evaluate RPN from " + expression + " = " + evalRPN(convertedExpression));
    }
}
