package P3_RevesePolishNotation_RadixSort;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReversePolishNotation_debug {
	static Scanner sc = new Scanner(System.in);
	
	public static String convertRPN(String str) {
		Deque<String> operatorStack = new ArrayDeque<>();
		Deque<String> finalQueue = new ArrayDeque<>();
		String[] inputStr = str.split(" ");
		String postFixedForm = "";
		
		for(int i = 0; i < inputStr.length; i++) {
			System.out.print(inputStr[i]);
		}
		System.out.println();
 		
		for (int i = 0; i < inputStr.length; i++) {
			System.out.println("Pasul " + i);
			System.out.println(inputStr[i]);
			String token = inputStr[i];
			System.out.println("tokenul: " + token);
			if (isNumber(token)) {
				finalQueue.addLast(token);
				System.out.println("varful cozii finale: " + finalQueue.peekLast());
			} else if (isOperator(token)) {
				System.out.println(token + " is operator token");
				String op1 = token;
				System.out.println(op1 + " is operator op1");
				System.out.println("operatorStack is empty? " + operatorStack.isEmpty());
				while (!operatorStack.isEmpty() &&  ( !operatorStack.peek().equals("(") && (((precedence(op1) < precedence(operatorStack.peek())) || ((precedence(op1) == precedence(operatorStack.peek()))) && (hasAsociativityLeft(operatorStack.peek())))) ) )  {
	
					System.out.println("operatorul din stiva: " + operatorStack.peek());
					sc.nextLine();
					finalQueue.addLast(operatorStack.poll());
					System.out.println("S-a introdus un operator in coada finala: " + finalQueue.peekLast());
					sc.nextLine();
					
				}
				operatorStack.push(op1);
				System.out.println("S-a introdus un operator in stiva: " + operatorStack.peek());
				sc.nextLine();

				
			} else if (token.equals("(")) {
				operatorStack.push(token);
				System.out.println("Paranteza ( din stiva: " + operatorStack.peek());
			} else if (token.equals(")")) {
				System.out.println("S-a intrat pe ramura )");
				while (!operatorStack.peek().equals("(")) {
					System.out.println("Se introduce operatorul in stiva: " + operatorStack.peek());
					finalQueue.add(operatorStack.pop());
				}
				if (operatorStack.isEmpty()) {
					throw new NoSuchElementException("Did not found correct bracket in stack");
				} 
//				operatorStack.pop();
				System.out.println("S-a extras " + operatorStack.pop());
			
			}
		}
		while (!operatorStack.isEmpty()) {
			String op = operatorStack.pop();
			System.out.println("La golirea stivei, op = " + op);
			if (op.equals("(")) {
				throw new NoSuchElementException("Wrong parentheses in expresion!");
			} else {
				finalQueue.addLast(op);
			}
		}
		while (!finalQueue.isEmpty()) {
			postFixedForm += finalQueue.removeFirst();
		}
		return postFixedForm;
	}
	
	public static int precedence(String str) {
		int result = 13;
		if (str.equals("+") || str.equals("-")) {
			System.out.println("S-a intrat pe ramura +- din precedence");
			result = 11;
		} else if (str.equals("*") || str.equals("/")) {
			System.out.println("S-a intrat pe ramura */ din precedence");
			result = 12;
		} 
//			else if (str.equals("^")) {
//			result = 13;
//		}
		System.out.println("S-a returnat " + result + " din precedence");
		return result;
	}
	
	public static boolean hasAsociativityLeft (String str) {
		boolean result = true;
		
		if (str.equals("^")) {
			System.out.println("S-a intrat pe ramura ^ din asociativity");
			result = false;
		}
		System.out.println("S-a returnat " + result + " din asociativity");
		return result;
	}
	
    public static int evalRPN(String[] tokens) {
        Deque<Integer> operandsStack = new ArrayDeque<>();
        int op1;
        int op2;
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
        	System.out.println(i + " este " + tokens[i]);
        	System.out.println(isNumber(tokens[i]));
        	if (isNumber(tokens[i])) {
        		operandsStack.push(Integer.valueOf(tokens[i]));
        		System.out.println("last operandsStack is number " + operandsStack.peek());
        	}
        	else {
        		switch (tokens[i]) {
        		case "+": 
        			System.out.println(tokens[i] + " tokens[i] la plus");
        			System.out.println(operandsStack.peek());
        			op1 = operandsStack.pop();
        			System.out.println("La + op1 " + op1);
        			System.out.println(operandsStack.peek());
        			op2 = operandsStack.pop();
        			System.out.println("La + op2 " +op2);
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
//        		default:
//        			operandsStack.push(Integer.parseInt(tokens[i]));
//        			System.out.println("la default operandsStack is number" + operandsStack.peek());
//        			break;
        		}
        		System.out.println("result " + result);
        		operandsStack.push(result);
        		
                System.out.println("La result last operandStack " + operandsStack.peek());
        	}
        }

//        System.out.println(operandsStack.peek());
//        printStack(operatorStack);
        return operandsStack.pop();
    }
    
    public static int power(int base, int exp) {
    	int result = 1;
    	for (int i = 1; i<=exp; i++) {
    		result *= base;
    	}
    	return result;
    }
    
    public static void printStack(Deque<Integer> stack) {
    	while (!stack.isEmpty()) {
    		System.out.println(stack.poll());
    	}
    }
    
    public static boolean isNumber(String string) {
    	char[] charArray = string.toCharArray();
    	int stringLength = string.length();
    	for (int i = 0; i<charArray.length; i++) {
    		if (charArray[0] == '-' ) {
    			if (stringLength > 1) {
    				i++;
    			}
    			else {
    				return false;
    			}
    		} else 
    		if (!Character.isDigit(charArray[i])) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static boolean isOperator(String str) {
    	if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^")) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
//    	String[] tokens = {"2", "1", "+", "3", "*"};
//    	String[] tokens2 = {"4", "13", "5", "/", "+"};
//    	String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//    	String[] tokens4 = {"4","-2","/","2","-3","-","-"};
//    	String[] tokens5 = {"3", "2", "1", "+", "2", "3", "2", "^", "^", "*", "+", "8", "5", "1", "2", "*", "2", "/", "-", "/", "-"};
    	
    	String expresion2 = "3 + ( 2 + 1 ) * 2 ^ 3 ^ 2 - 8 / ( 5 - 1 * 2 / 2 )";
//    	String expresion1 = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
    	
    	
////    	System.out.println("Rezultat final corect: " + evalRPN2(tokens2));
////    	System.out.println("Rezultat final corect: " + evalRPN2(tokens3));
//    	
//    	System.out.println("Rezultat final: " + evalRPN(tokens));
////    	System.out.println("Rezultat final corect: " + evalRPN2(tokens));
//    	System.out.println("==========================");
//    	System.out.println("Rezultat final: " + evalRPN(tokens2));
////    	System.out.println("Rezultat final corect: " + evalRPN2(tokens2));
//    	System.out.println("==========================");
//    	System.out.println("Rezultat final: " + evalRPN(tokens3));
////    	System.out.println("Rezultat final corect: " + evalRPN2(tokens3));
//    	System.out.println("==========================");
////    	System.out.println("Rezultat final corect: " + evalRPN2(tokens4));
//    	System.out.println("Rezultat final: " + evalRPN(tokens4));
//    	System.out.println("==========================");
//
//    	System.out.println(power(3,2));
//    	
//    	System.out.println("Rezultat final: " + evalRPN(tokens5));
//    	System.out.println("==========================");
    	
//    	String convertedExpresion1 = convertRPN(expresion1);
    	String convertedExpresion2 = convertRPN(expresion2);
//    	System.out.println(expresion1 + " In main, expresia convertita: " + convertedExpresion1 + " (Corect: 3 4 2 * 1 5 − 2 3 ^ ^ / +");
    	System.out.println(expresion2 + " In main, expresia convertita: " + convertedExpresion2 + " (Corect: 3 2 1 + 2 3 2 ^ ^ * + 8 5 1 2 * 2 / - / -)");
    	
//    	System.out.println("Rezultat final: " + evalRPN(convertedExpresion2));
    	

    }
}
