package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;
	
	protected BSTNode<T> NILL = new BSTNode<T>();
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		
		int height = -1;
		
		if (!this.isEmpty()) {
			
			height += this.height(this.root);
			
		}
		
		return height;
		
	}

	private int height(BSTNode<T> node) {
		
		int leftHeight = 0, rightHeigth = 0;
		
		if (!node.getLeft().isEmpty()) {
			
			leftHeight = this.height( (BSTNode<T>) node.getLeft());
			
		}
		
		
		if (!node.getRight().isEmpty()) {
			
			rightHeigth = this.height( (BSTNode<T>) node.getRight());
			
		}
		
		return 1 + Math.max(leftHeight, rightHeigth);
		
	}

	@Override
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
	@Override
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

	@Override
	public BSTNode<T> maximum() {
		
		return this.maximum(this.root);
		
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		
		BSTNode<T> returnNode = null;
		
		if (!node.isEmpty()) {
			
			returnNode = node;
			
			if (!node.getRight().isEmpty()) {
				
				returnNode = this.maximum((BSTNode<T>) node.getRight());
				
			}
			
		}
		
		return returnNode;
		
	}

	@Override
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

	@Override
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

	@Override
	public BSTNode<T> predecessor(T element) {
		
		BSTNode<T> node = this.search(element);
		BSTNode<T> returnNode = null;
		
		if (!node.isEmpty()) {
			
			if (!node.getLeft().isEmpty()) {
				
				returnNode = this.maximum( (BSTNode<T>) node.getLeft());
				
			} else {
				
				while (!node.isEmpty() && this.sideOfNode(node) == -1) {
					
					node = (BSTNode<T>) node.getParent();
					
				}
				
				returnNode = (BSTNode<T>) node.getParent();
				
			}
			
		}
		
		return returnNode;
		
	}
	

	@Override
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
	
	public int sideOfNode(BSTNode<T> node) {
		
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
	

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		
		List<T> list = new ArrayList<>();
		this.preOrder(this.root, list);
		return (T[]) list.toArray(new Comparable[list.size()]);
		
	}
	

	private void preOrder(BSTNode<T> node, List<T> list) {
		
		if (!node.isEmpty()) {
			
			list.add(node.getData());
			
			if (!node.getLeft().isEmpty()) {
				
				this.preOrder( (BSTNode<T>) node.getLeft(), list);
				
			}
			
			if (!node.getRight().isEmpty()) {
				
				this.preOrder( (BSTNode<T>) node.getRight(), list);
				
			}
			
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		
		List<T> list = new ArrayList<>();
		this.order(this.root, list);
		return (T[]) list.toArray(new Comparable[list.size()]);
		
	}

	private void order(BSTNode<T> node, List<T> list) {
		
		if (!node.isEmpty()) {
		
			if (!node.getLeft().isEmpty()) {
				
				this.order( (BSTNode<T>) node.getLeft(), list);
				
			}
			
			list.add(node.getData());
			
			if (!node.getRight().isEmpty()) {
				
				this.order( (BSTNode<T>) node.getRight(), list);
				
			}
			
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		
		List<T> list = new ArrayList<>();
		this.postOrder(this.root, list);
		return (T[]) list.toArray(new Comparable[list.size()]);
		
	}

	private void postOrder(BSTNode<T> node, List<T> list) {
		
		if (!node.isEmpty()) {
		
			if (!node.getLeft().isEmpty()) {
				
				this.postOrder( (BSTNode<T>) node.getLeft(), list);
				
			}
			
			if (!node.getRight().isEmpty()) {
				
				this.postOrder( (BSTNode<T>) node.getRight(), list);
				
			}
			
			list.add(node.getData());
			
		}
		
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
