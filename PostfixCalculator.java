import java.util.Stack;
/**
 * Class that takes a given postfix expression and calculates it
 * @author Ryan Rice
 * @version 04.24.2018
 */
public class PostfixCalculator {
	
	private Stack<Double> memory;
	
	public PostfixCalculator(){
		
		memory = new Stack<Double>();
	}
	/**
	 * Calculation function for a given postfix
	 * @param postfix
	 * @return value
	 */
	public String Calculate(String postfix){
		int i = 0;

		memory.clear();

		for(int n=0;n<postfix.length();n++){
			
			char ch = postfix.charAt(n);
			
			if('0'<=ch && ch<='9')
				
				memory.push(new Double(ch-'0'));
			else {

				switch(ch) {

					case '+':

						double b = memory.pop();
						double a = memory.pop();
						memory.push(a+b);
						break;

					case '-':

						b = memory.pop();
						a = memory.pop();
						memory.push(a-b);
						break;

					case '*':

						b = memory.pop();
						a = memory.pop();
						memory.push(a*b);
						break;

					case '/':

						b = memory.pop();
						a = memory.pop();
						memory.push(a/b);
						break;

					case '^':

						b = memory.pop();
						a = memory.pop();
						memory.push(Math.pow(a,b));
						break;

					}

				}

			}

			return memory.pop().toString();

		}
		
	}
