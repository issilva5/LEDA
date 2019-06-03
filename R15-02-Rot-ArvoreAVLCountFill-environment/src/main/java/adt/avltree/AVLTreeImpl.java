package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	@Override
	public void insert(T element) {
		this.insert(this.root, element);
	}
	
	private void insert(BSTNode<T> node, T element) {
		
		if (node.isEmpty()) {
			
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
			
			rebalanceUp(node);
			
		} else if (element.compareTo(node.getData()) > 0) {
			
			this.insert((BSTNode<T>) node.getRight(), element);
			
		} else if (element.compareTo(node.getData()) < 0) {
			
			this.insert((BSTNode<T>) node.getLeft(), element);
			
		}
		
	}

	@Override
	public void remove(T element) {
		
		if (element != null) {
			
			BSTNode<T> node = this.search(element);
			
			if (!node.isEmpty()) {
				
				int degree = this.exitDegree(node);
				
				if (degree == 0) {
					
					node.setData(null);
					rebalanceUp(node);
					
				} else if (degree == 1) {
					
					if (node.getParent() == null) {
						
						if (!node.getLeft().isEmpty()) {
							
							node.getLeft().setParent(null);
							this.root = (BSTNode<T>) node.getLeft();
							rebalanceUp(this.root);
							
						} else {
							
							node.getRight().setParent(null);
							this.root = (BSTNode<T>) node.getRight();
							rebalanceUp(this.root);
							
						}
						
					} else {
						
						BSTNode<T> nodeAux = null;
						
						if (!node.getRight().isEmpty()) {
							
							nodeAux = (BSTNode<T>) node.getRight();
							
						} else {
							
							nodeAux = (BSTNode<T>) node.getLeft();
							
						}
							
						nodeAux.setParent(node.getParent());
							
						if (node.equals(node.getParent().getLeft())) {
							
							node.getParent().setLeft(nodeAux);
						
						} else if (node.equals(node.getParent().getRight())){
							
							node.getParent().setRight(nodeAux);
						}
						
						rebalanceUp(nodeAux);
						
					}
					
				} else {
					
					BSTNode<T> sucessorNode = this.sucessor(node.getData());
					
					if (sucessorNode != null) {
					
						T aux = sucessorNode.getData();
						
						remove(sucessorNode.getData());
						
						node.setData(aux);
						
					}
					
				}
				
			}
			
		}
		
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		
		if (node == null || node.isEmpty()) {
			return 0;
		}
		
		return this.height((BSTNode<T>) node.getRight()) - this.height((BSTNode<T>) node.getLeft());
		
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		
		int balance = this.calculateBalance(node);
		
		if (balance < -1) {
			
			int balanceLeft = this.calculateBalance((BSTNode<T>) node.getLeft());
			
			if (balanceLeft > 0) {
				
				this.leftRotation((BSTNode<T>) node.getLeft());
		
			}
			
			this.rightRotation(node);
			
		} else if (balance > 1) {
			
			int balanceRight = this.calculateBalance((BSTNode<T>) node.getRight());
			
			if (balanceRight < 0) {
				
				this.rightRotation((BSTNode<T>) node.getRight());
				
			}
			
			this.leftRotation(node);
			
		}
		
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			rebalance(node);
			rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
	
	//AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.leftRotation(node);
		if (newNode.getParent() == null) {
			this.root = newNode;
		}
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.rightRotation(node);
		if (newNode.getParent() == null) {
			this.root = newNode;
		}
	}
}
