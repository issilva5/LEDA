package pilha_com_array;

import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in), aux;
		int size = Integer.parseInt(sc.nextLine());
		Stack pilha = new Stack(size);
		String line, option;
		
		do {
			
			line = sc.nextLine();
			aux = new Scanner(line);
			option = aux.next();
			boolean status;
			
			switch (option) {
				case "print":
					System.out.println(pilha.toString());
					break;
				
				case "peek":
					System.out.println(pilha.peek());
					break;
				
				case "pop":
					status = pilha.pop();
					if (!status)
						System.out.println("empty");
					break;
				
				case "push":
					status = pilha.push(Integer.parseInt(aux.next()));
					if (!status)
						System.out.println("full");
					break;
	
				default:
					break;
			}
			
			aux.close();
			
		} while (!option.equals("end"));

		sc.close();

	}
	
	private static class Stack {
		
		private int[] stack;
		private int size;
		
		public Stack(int capacity) {
			this.stack = new int[capacity];
			this.size = -1;
		}
		
		public boolean push(int element) {
			
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
		
		public int peek() {
			
			return this.stack[this.size];
			
		}
		
		public boolean isEmpty() {
			
			return this.size == -1;
			
		}
		
		public boolean isFull() {
			
			return this.size == (this.stack.length - 1);
			
		}
		
		@Override
		public String toString() {
			if (this.isEmpty())
				return "empty";
			
			Stack aux = new Stack(this.size + 1);
			
			while (!this.isEmpty()) {
				
				aux.push(this.peek());
				this.pop();
				
			}
			
			String text = "";
			while (!aux.isEmpty()) {
				
				text += aux.peek();
				this.push(aux.peek());
				aux.pop();
				
				if (!aux.isEmpty()) {
					
					text += " ";
					
				}
				
			}
			
			return text;
		}
		
	}
	
}

