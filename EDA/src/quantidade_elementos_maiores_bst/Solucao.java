package quantidade_elementos_maiores_bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BST bst = new BST();
		
		for (String node : sc.nextLine().split(" ")) bst.insert(Integer.parseInt(node));
		
		int toSearch = Integer.parseInt(sc.nextLine());
		
		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(bst.higherThan(toSearch));
		
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
		
		public int higherThan(int value) {
			
			return this.higherThan(value, this.root);
			
		}
		
		private int higherThan(int value, Node node) {
			
			if (node == null) {
				
				return 0;
				
			}
			
			if (value == node.value) {
				
				return this.size(node.right);
				
			} else if (value < node.value) {
				
				return 1 + this.size(node.right) + this.higherThan(value, node.left);
				
			} else {
				
				return this.higherThan(value, node.right);
				
			}
			
		}
		
		public int size(Node node) {
			
			if (node == null)
				return 0;
			
			return 1 + this.size(node.left) + this.size(node.right);
			
		}
		
		public Integer[] preOrder() {
			
			ArrayList<Integer> list = new ArrayList<>();
			this.preOrder(this.root, list);
			return list.toArray(new Integer[list.size()]);
			
		}

		private void preOrder(Node node, ArrayList<Integer> list) {
			
			list.add(node.value);
			
			if (node.left != null)
				this.preOrder(node.left, list);
			
			if (node.right != null)
				this.preOrder(node.right, list);
			
		}
		

		
	}
	
}
