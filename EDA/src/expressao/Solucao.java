package expressao;

import java.util.Scanner;

public class Solucao {
	
	private static boolean isOperator(char a) {
		
		return a == '+' || a == '-' || a == '*' || a == '/';
		
	}
	
	private static Integer operate(Integer firstOperand, Integer secondOperand, Character operator) {
		
		switch (operator) {
			case '+':
				return new Integer(firstOperand.intValue() + secondOperand.intValue());
			
			case '-':
				return new Integer(firstOperand.intValue() - secondOperand.intValue());
				
			case '*':
				return new Integer(firstOperand.intValue() * secondOperand.intValue());
				
			case '/':
				return new Integer(firstOperand.intValue() / secondOperand.intValue());
	
			default:
				throw new IllegalArgumentException("Invalid operator");
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		Stack<Integer> operands = new Stack<>(line.length());
		Stack<Character> operators = new Stack<>(line.length());
		
		int iterator = 0;
		
		while (iterator < line.length()) {
			
			char actual = line.charAt(iterator);
			
			if (isOperator(actual)) {
				operators.push(actual);
			} else if (Character.isDigit(actual)) {
				
				String number = "";
				
				while (iterator < line.length()) {
					
					if (Character.isDigit(line.charAt(iterator)))
						number += line.charAt(iterator);
					else {
						iterator--;
						break;
					}
					
					iterator++;
					
				}
				
				operands.push(Integer.parseInt(number));
				
			} else if (actual == ')') {
				
				Integer secondOperand = operands.peek();
				operands.pop();
				
				Integer firstOperand = operands.peek();
				operands.pop();
				
				Character operator = operators.peek();
				operators.pop();
				
				operands.push(operate(firstOperand, secondOperand, operator));
			}
			
			iterator++;
			
		}
		
		while (!operators.isEmpty()) {
			
			Integer secondOperand = operands.peek();
			operands.pop();
			
			Integer firstOperand = operands.peek();
			operands.pop();
			
			Character operator = operators.peek();
			operators.pop();
			
			operands.push(operate(firstOperand, secondOperand, operator));
			
		}
		
		System.out.println(operands.peek());
		
		sc.close();
	}
	
	private static class Stack<T> {
		
		private T[] stack;
		private int size;
		
		@SuppressWarnings("unchecked")
		public Stack(int capacity) {
			this.stack = (T[]) new Object[capacity];
			this.size = -1;
		}
		
		public boolean push(T element) {
			
			if (this.isFull()) {
				
				return false;
				
			}
			
			this.size++;
			this.stack[this.size] = element;
			return true;
			
		}
		
		public boolean pop() {
			
			if (this.isEmpty()) {
				
				return false;
				
			}
			
			this.size--;
			return true;
			
		}
		
		public T peek() {
			
			return this.stack[this.size];
			
		}
		
		public boolean isEmpty() {
			
			return this.size == -1;
			
		}
		
		public boolean isFull() {
			
			return this.size == (this.stack.length - 1);
			
		}
		
	}
	
}

