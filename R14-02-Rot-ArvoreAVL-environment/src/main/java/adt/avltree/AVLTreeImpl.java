package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

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
		// TODO Auto-generated method stub
		super.insert(element);
	}
	
	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		super.remove(element);
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		
		if (node == null || node.isEmpty()) {
			return 0;
		}
		
		return this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
