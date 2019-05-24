package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		this.clear();
		
		for (T elem : array) {
			
			this.insert(elem);
			
		}
		
		return this.order();
	}
	
	private void clear() {
		
		while (!this.isEmpty()) {
			
			this.remove(this.root.getData());
			
		}
		
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
		
		int compareValue = this.comparator.compare(element, node.getData());
		
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
	public BSTNode<T> search(T element) {
		
		return this.search(element, this.root);
		
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		
		BSTNode<T> returnNode = NILL;
		
		if (!node.isEmpty()) {
			
			int compareValue = this.comparator.compare(element, node.getData());
		
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
	
	@Override
	public int sideOfNode(BSTNode<T> node) {
		
		int side = 0;
		
		if (node.getParent() != null) {
			
			if (this.comparator.compare(node.getData(), node.getParent().getData()) < 0) {
				
				side = -1;
				
			} else {
				
				side = 1;
				
			}
			
		}
		
		return side;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] reverseOrder() {
	
		List<T> list = new ArrayList<>();
		this.reverseOrder(this.root, list);
		return (T[]) list.toArray(new Comparable[list.size()]);
		
	}

	private void reverseOrder(BSTNode<T> node, List<T> list) {
		
		if (!node.isEmpty()) {
		
			
			if (!node.getRight().isEmpty()) {
				
				this.reverseOrder( (BSTNode<T>) node.getRight(), list);
				
			}
			
			list.add(node.getData());
			
			if (!node.getLeft().isEmpty()) {
				
				this.reverseOrder( (BSTNode<T>) node.getLeft(), list);
				
			}
			
		}
		
		
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
