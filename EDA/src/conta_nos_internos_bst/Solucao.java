package conta_nos_internos_bst;

import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BST bst = new BST();
		
		for (String node : sc.nextLine().split(" ")) bst.insert(Integer.parseInt(node));
		
		sc.close();
		
		System.out.println(bst.innerNodes());
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
		
		public int innerNodes() {
			
			if (this.root == null) {
				
				return -1;
				
			} else {
				
				return this.innerNodes(this.root);
				
			}
			
		}

		private int innerNodes(Node node) {
			
			if (node.exitDegree() == 0) {
				
				return 0;
				
			} else if (node.exitDegree() == 1) {
				
				if (node.left != null) {
					
					return 1 + this.innerNodes(node.left);
					
				} else {
					
					return 1 + this.innerNodes(node.right);
					
				}
				
			} else {
				
				return 1 + this.innerNodes(node.left) + this.innerNodes(node.right);
				
			}
			
		}

		
	}
	
}
