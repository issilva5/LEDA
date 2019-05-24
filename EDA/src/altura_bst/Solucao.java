package altura_bst;

import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] nodes = sc.nextLine().split(" ");
		
		BST bst = new BST();
		
		for (String node : nodes) bst.insert(Integer.parseInt(node));
		
		System.out.println(bst.height());
		
		sc.close();
		
	}
	
	private static class Node {
		
		public Node parent;
		public Node left;
		public Node right;
		public int value;
		
		public Node(int value) {
			this(value, null);
		}

		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
		}
		
		public int exitDegree() {
			
			return (this.left == null ? 0 : 1) + (this.right == null ? 0 : 1);
			
		}
		
	}
	
	private static class BST {
		
		private Node root;
		
		public void insert(int value) {
			
			if (this.root == null) {
				
				this.root = new Node(value);
				
			} else {
				
				this.insert(value, this.root);
				
			}
			
		}

		private void insert(int value, Node node) {
			
			if (value != node.value) {
				
				if (value < node.value) {
					
					if (node.left == null) {
						
						node.left = new Node(value, node);
						
					} else {
						
						this.insert(value, node.left);
						
					}
					
				} else {
					
					if (node.right == null) {
						
						node.right = new Node(value, node);
						
					} else {
						
						this.insert(value, node.right);
						
					}
					
				}
				
			}
			
		}
		
		public int height() {
			
			if (this.root == null) {
				
				return -1;
				
			} else {
				
				return this.height(this.root);
				
			}
			
		}

		private int height(Node node) {
			
			if (node.exitDegree() == 0) {
				
				return 0;
				
			} else if (node.exitDegree() == 1) {
				
				if (node.left != null) {
					
					return 1 + this.height(node.left);
					
				} else {
					
					return 1 + this.height(node.right);
					
				}
				
			} else {
				
				return 1 + Math.max(this.height(node.left), this.height(node.right));
				
			}
			
		}
		
	}
	
	
}
