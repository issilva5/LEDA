package linked_list;

import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		Scanner sc = new Scanner(System.in);
		
		String option; int aux;
		
		do {
			
			option = sc.next();
			
			switch (option) {
				case "print":
					String toPrint = queue.toString();
					if (toPrint.equals("")) {
						System.out.println("empty");
						break;
					}
					
					System.out.println(toPrint);
					break;
					
				case "element":
					aux = queue.element();
					if (aux == -1) System.out.println("empty");
					else System.out.println(aux);
					break;
					
				case "remove":
					if (!queue.remove()) {
						System.out.println("empty");
					}
					break;
					
				case "add":
					aux = sc.nextInt();
					queue.add(aux);
					sc.nextLine();
					break;
				
				case "search":
					aux = sc.nextInt();
					System.out.println(queue.search(aux));
					break;
					
				default:
					break;
			}
			
		} while (!option.equals("end"));
		
		sc.close();
		
	}
	
	private static class DoubleLinkedList {
		
		private Node head;
		
		public void add(int element) {
			
			if (this.head == null) {
				
				head = new Node(element);
				
			} else {
				
				head.add(element);
				
			}
			
		}
		
		public boolean removeFirst() {
			
			if (this.head != null) {
				this.head = this.head.next;
				return true;
			}
			
			return false;
			
		}
		
		public int element() {
			
			if (this.head != null) 
				return this.head.value;
			
			return -1;
			
		}
		
		public int search(int element) {
			
			if (this.head != null) {
				return this.head.getPos(element, 0);
			}
			
			return -1;
			
		}
		
		@Override
		public String toString() {
			
			if (this.head != null) {
				return this.head.toString("");
			}
			
			return "";
		}
		
	}
	
	private static class Node {
		
		private int value;
		private Node next;
		private Node previous;
		
		public Node(int element) {
			
			this.value = element;
			
		}

		public String toString(String string) {
			
			string += this.value;
			
			if (this.next != null) {
				
				string += " ";
				return this.next.toString(string);
				
			}
			
			return string;
			
		}

		public int getPos(int element, int i) {
			
			if (this.value == element) {
				
				return i;
				
			} else {
				
				if (this.next != null) {
					
					return this.next.getPos(element, i+1);
					
				} else {
					
					return -1;
					
				}
				
			}
			
		}

		public void add(int element) {
			
			if (this.next == null) {
				
				this.next = new Node(element);
				this.next.previous = this;
				
			} else {
				
				this.next.add(element);
				
			}
			
		}
		
	}
	
	private static class Queue {
		
		private DoubleLinkedList list;
		
		public Queue() {
			list = new DoubleLinkedList();
		}
		
		public void add(int element) {
			
			this.list.add(element);
			
		}
		
		public boolean remove() {
			
			return this.list.removeFirst();
			
		}
		
		public int element() {
			
			return this.list.element();
			
		}
		
		public int search(int element) {
			
			return this.list.search(element);
			
		}
		
		@Override
		public String toString() {
			return this.list.toString();
		}
		
	}
	
}
