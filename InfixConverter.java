import java.util.Stack;
/**
 * InfixConverter class to convert a given infix to postfix
 * @author Ryan Rice
 * @version 04.24.2018
 */
public class InfixConverter {
 
	private Stack<Character> stack;
    /**
     * Constructor for infix converter
     */
 	public InfixConverter(){
 		stack = new Stack<Character>();
 	}
 	/**
 	 * method that converts a given string infix to a string postfix
 	 * @param infix
 	 * @return postfix
 	 */
 	public String converter(String infix){
 		char[] chars = infix.toCharArray();
 		Stack<Character> output = new Stack<Character>();
 		int x = 0;
 		while(x < chars.length){
 			
 			if(chars[x] == '('){
 				stack.push(chars[x]);
 				
 			}
 			else
 			if(chars[x] == ')'){
 				while(stack.peek() != '('){
 					output.push(stack.peek());
 					stack.pop();
 				}
 				if(stack.peek() == '('){
 					stack.pop();
 				}
 			}
 			else
 			if(chars[x] == '^' || chars[x] == '/' || chars[x] == '*' || chars[x] == '+' || chars[x] == '-'){
 				  while(!stack.isEmpty() && stack.peek() != '('){
 					 if(chars[x] == '^' && (stack.peek() != '/' || stack.peek() != '*' || stack.peek() != '+' || stack.peek() != '-')){
 						 output.push(stack.peek());
 						 stack.pop();
 					 }
 					 else
 					 if(chars[x] == '^' && (stack.peek() == '/' || stack.peek() == '*' || stack.peek() == '+' || stack.peek() == '-'))
 					 {
 						 break;
 					 }
 					else	 
 					if((chars[x] == '*' || chars[x] == '/') && (stack.peek() != '-' || stack.peek() != '+')){
 						output.push(stack.peek());
 						stack.pop();
 					 }
 					else
 					if(chars[x] == '*' || chars[x] == '/' && (stack.peek() == '^' || stack.peek() == '*') || stack.peek() == '/'){
 						break;
 					} 
 					else
 					if(chars[x] == '+' || chars[x] == '-'){
 						output.push(stack.peek());
 						stack.pop();
 					 }
 				  }	
 				  stack.push(chars[x]);
 			   }
 			else {
 				output.push(chars[x]);
 			}
 			x++;	
 			}
 		 while(!stack.isEmpty()){
 			 output.push(stack.peek());
 			 stack.pop();
 		}
 		 return output.toString();
 	}
}
