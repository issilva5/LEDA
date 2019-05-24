package bfs_direita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solucao {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] nodes = sc.nextLine().split(" ");
		
		BSTImpl<Integer> bst = new BSTImpl<>();
		
		for (String node : nodes) bst.insert(Integer.parseInt(node));
		
		String out = "";
		
		ArrayList< BTNode<Integer> > list = new ArrayList<>();
		
		if (!bst.isEmpty()) {
			
			list.add(bst.getRoot());
			
		}
		
		while (!list.isEmpty()) {
			
			BTNode<Integer> front = list.remove(0);
			out += (out.isEmpty() ? "" : " ") + front.data;
			
			if (!front.right.isEmpty()) {
				
				list.add(front.right);
				
			}
			
			if (!front.left.isEmpty()) {
				
				list.add(front.left);
				
			}
			
		}
		
		System.out.println(out);
		
	}
	
	public static class BTNode<T> {
		protected T data;
		protected BTNode<T> left;
		protected BTNode<T> right;
		protected BTNode<T> parent;

		public BTNode(T data, BTNode<T> left, BTNode<T> right, BTNode<T> parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		public BTNode() {
		}

		public boolean isEmpty() {
			return this.data == null;
		}

		public boolean isLeaf() {
			return this.data != null && this.left.isEmpty() && this.right.isEmpty();
		}
		
		@Override
		public String toString() {
			String resp = "NIL";
			if (!isEmpty()) {
				resp = data.toString();
			}
			return resp;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			boolean resp = false;
			if (obj instanceof BTNode) {
				if (!this.isEmpty() && !((BTNode<T>) obj).isEmpty()) {
					resp = this.data.equals(((BTNode<T>) obj).data);
				} else {
					resp = this.isEmpty() && ((BTNode<T>) obj).isEmpty();
				}

			}
			return resp;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public BTNode<T> getLeft() {
			return left;
		}

		public void setLeft(BTNode<T> left) {
			this.left = left;
		}

		public BTNode<T> getRight() {
			return right;
		}

		public void setRight(BTNode<T> right) {
			this.right = right;
		}

		public BTNode<T> getParent() {
			return parent;
		}

		public void setParent(BTNode<T> parent) {
			this.parent = parent;
		}
	}
	
	public static class BSTNode<T extends Comparable<T>> extends BTNode<T> {
		
		public BSTNode() {
			super();
		}
		
		public static class Builder<T>{
			T data;
			BTNode<T> left;
			BTNode<T> right;
			BTNode<T> parent;
		       
		    public BSTNode.Builder<T> data(T data){
		      this.data = data;
		      return this;
		    }
		    
		    public BSTNode.Builder<T> left(BTNode<T> left){
		      this.left = left;
		      return this;
		    }
		    
		    public BSTNode.Builder<T> right(BTNode<T> right){
			      this.right = right;
			      return this;
			}
		    
		    public BSTNode.Builder<T> parent(BTNode<T> parent){
			      this.parent = parent;
			      return this;
			}
		    
		     public BSTNode build(){
		      return new BSTNode(this);
		    }
		 }
		private BSTNode(BSTNode.Builder<T> builder){
		    this.data = builder.data;
		    this.left = builder.left;
		    this.right = builder.right;
		    this.parent = builder.parent;
		    
		}
	}
	
	public static class BSTImpl<T extends Comparable<T>> {

		protected BSTNode<T> root;
		
		private BSTNode<T> NILL = new BSTNode<T>();
		
		public BSTImpl() {
			root = new BSTNode<T>();
		}

		public BSTNode<T> getRoot() {
			return this.root;
		}

		public boolean isEmpty() {
			return root.isEmpty();
		}

		public BSTNode<T> search(T element) {
			
			return this.search(element, this.root);
			
		}

		private BSTNode<T> search(T element, BSTNode<T> node) {
			
			BSTNode<T> returnNode = NILL;
			
			if (!node.isEmpty()) {
				
				int compareValue = element.compareTo(node.getData());
			
				if (compareValue == 0) {
					
					returnNode = node;
					
				} else {
					
					if (compareValue < 0) {
						
						if (!node.getLeft().isEmpty()) {
							
							returnNode = this.search(element, (BSTNode<T>) node.getLeft());
							
						}
						
					} else {
						
						if (!node.getRight().isEmpty()) {
							
							returnNode = this.search(element, (BSTNode<T>) node.getRight());
							
						}
						
					}
					
				}
				
			}
			
			return returnNode;
			
			
		}
		

		@SuppressWarnings("unchecked")
		public void insert(T element) {
			
			if (this.isEmpty()) {
				
				this.root = (BSTNode<T>) new BSTNode.Builder<T>()
						.data(element)
						.left(NILL)
						.right(NILL)
						.parent(null)
						.build();
				
			} else {
				
				this.insert(element, this.root);
				
			}
			
		}

		@SuppressWarnings("unchecked")
		private void insert(T element, BSTNode<T> node) {
			
			int compareValue = element.compareTo(node.getData());
			
			if (compareValue != 0) {
				
				if (compareValue < 0) {
					
					if (node.getLeft().isEmpty()) {
						
						BSTNode<T> left = (BSTNode<T>) new BSTNode.Builder<T>()
								.data(element)
								.left(NILL)
								.right(NILL)
								.parent(node)
								.build();
						
						node.setLeft(left);
						
					} else {
						
						this.insert(element, (BSTNode<T>) node.getLeft());
						
					}
					
				} else {
					
					if (node.getRight().isEmpty()) {
						
						BSTNode<T> right = (BSTNode<T>) new BSTNode.Builder<T>()
								.data(element)
								.left(NILL)
								.right(NILL)
								.parent(node)
								.build();
						
						node.setRight(right);
						
					} else {
						
						this.insert(element, (BSTNode<T>) node.getRight());
						
					}
					
				}
				
			}
			
			
		}

		public BSTNode<T> minimum() {
		
			return this.minimum(this.root);
		
		}

		private BSTNode<T> minimum(BSTNode<T> node) {
			
			BSTNode<T> returnNode = null;
			
			if (!node.isEmpty()) {
				
				returnNode = node;
				
				if (!node.getLeft().isEmpty()) {
					
					returnNode = this.minimum((BSTNode<T>) node.getLeft());
					
				}
				
			}
			
			return returnNode;
			
		}

		public BSTNode<T> sucessor(T element) {
			
			BSTNode<T> node = this.search(element);
			BSTNode<T> returnNode = null;
			
			if (!node.isEmpty()) {
				
				if (!node.getRight().isEmpty()) {
					
					returnNode = this.minimum( (BSTNode<T>) node.getRight());
					
				} else {
					
					while (!node.isEmpty() && this.sideOfNode(node) == 1) {
						
						node = (BSTNode<T>) node.getParent();
						
					}
					
					returnNode = (BSTNode<T>) node.getParent();
					
				}
				
			}
			
			return returnNode;
			
		}
		
		public void remove(T element) {
			
			BSTNode<T> toRemove = this.search(element);
			
			if (!toRemove.isEmpty()) {
				
				int nodeExitD = this.exitDegree(toRemove);
				int nodeSide = this.sideOfNode(toRemove);
				
				if (nodeExitD == 0) {
					
					if (toRemove.getParent() == null) {
						
						this.root = NILL;
						
					} else {
						
						if (nodeSide == -1) {
							
							toRemove.getParent().setLeft(NILL);
							
						} else {
							
							toRemove.getParent().setRight(NILL);
							
						}
						
					}
					
				} else if (nodeExitD == 1) {
					
					if (toRemove.getParent() == null) {
						
						if (!toRemove.getLeft().isEmpty()) {
							
							toRemove.getLeft().setParent(null);
							this.root = (BSTNode<T>) toRemove.getLeft();
							
						} else {
							
							toRemove.getRight().setParent(null);
							this.root = (BSTNode<T>) toRemove.getRight();
							
						}
						
					} else {
						
						if (nodeSide == -1) {
							
							if (!toRemove.getLeft().isEmpty()) {
								
								toRemove.getParent().setLeft(toRemove.getLeft());
								toRemove.getLeft().setParent(toRemove.getParent());
								
							} else {
								
								toRemove.getParent().setLeft(toRemove.getRight());
								toRemove.getRight().setParent(toRemove.getParent());
								
							}
							
						} else {
							
							if (!toRemove.getLeft().isEmpty()) {
								
								toRemove.getParent().setRight(toRemove.getLeft());
								toRemove.getLeft().setParent(toRemove.getParent());
								
							} else {
								
								toRemove.getParent().setRight(toRemove.getRight());
								toRemove.getRight().setParent(toRemove.getParent());
								
							}
							
						}
						
					}
					
				} else {
					
					BSTNode<T> sucessorNode = this.sucessor(toRemove.getData());
					
					T aux = sucessorNode.getData();
					
					remove(sucessorNode.getData());
					
					toRemove.setData(aux);
					
					
					
				}
				
			}
			
		}
		
		
		private int exitDegree(BSTNode<T> node) {
			
			int exitDegree = 0;
			
			if (!node.getLeft().isEmpty()) {
				
				exitDegree++;
				
			}
			
			if (!node.getRight().isEmpty()) {
				
				exitDegree++;
				
			}
			
			return exitDegree;
			
		}
		
		private int sideOfNode(BSTNode<T> node) {
			
			int side = 0;
			
			if (node.getParent() != null) {
				
				if (node.getData().compareTo(node.getParent().getData()) < 0) {
					
					side = -1;
					
				} else {
					
					side = 1;
					
				}
				
			}
			
			return side;
			
		}
		
	}
	
}
