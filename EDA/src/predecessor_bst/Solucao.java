package predecessor_bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BST bst = new BST();
		
		for (String node : sc.nextLine().split(" ")) bst.insert(Integer.parseInt(node));
		
		int toPred = Integer.parseInt(sc.nextLine());
		
		System.out.println(Arrays.toString(bst.predecessor(toPred)));
		
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

		private Node search(int value, Node node) {
			
			if (value == node.value) {
				
				return node;
				
			} else if (value < node.value) {
					
				if (node.left != null) {
					
					return this.search(value, node.left);
					
				}
				
				return null;
				
			} else {
				
				if (node.right != null) {
					
					return this.search(value, node.right);
					
				}
				
				return null;
				
			}
			
		}
	
		public Integer[] predecessor(int value) {
			
			ArrayList<Integer> list = new ArrayList<>();
			
			Node node = this.search(value, this.root);
			
			if (node.left != null) {
				
				list.add(node.value);
				
				Node leftAux = node.left;
				
				while (leftAux != null) {
					
					list.add(leftAux.value);
					leftAux = leftAux.right;
					
				}
				
			} else {
				
				list.add(node.value);
				
				while (node.parent != null) {
					
					if (value > node.parent.value) {
						
						list.add(node.parent.value);
						break;
						
					}
					
					node = node.parent;					
					list.add(node.value);
					
				}
				
			}
			
			return list.toArray(new Integer[list.size()]);
			
		}
		
	}
	
}
