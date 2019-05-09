package tree;

public class BinarySearchTree<T extends Comparable<T> > extends BinaryTree<T> {
	
	/**
	 * @see tree.BinaryTree#insert(Object)
	 */
	@Override
	public void insert(T element) {
		
		if (this.isEmpty()) {
			
			this.root = new BinaryNode<T>(element);
			
		} else {
			
			this.insert(element, this.root);
			
		}
		
	}

	private void insert(T element, BinaryNode<T> node) {
		
		int compareValue = element.compareTo(node.getData());
		
		if (compareValue != 0) {
			
			if (compareValue < 0) {
				
				if (node.getLeft() == null) {
					
					node.setLeft(new BinaryNode<T>(element));
					
				} else {
					
					this.insert(element, node.getLeft());
					
				}
				
			} else {
				
				if (node.getRight() == null) {
					
					node.setRight(new BinaryNode<T>(element));
					
				} else {
					
					this.insert(element, node.getRight());
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * @see tree.BinaryTree#contains(Object)
	 */
	@Override
	public boolean contains(T element) {
		
		return this.contains(element, this.root);
		
	}

	private boolean contains(T element, BinaryNode<T> node) {
		
		boolean isIn = false;
		
		if (node != null) {
			
			int compareValue = element.compareTo(node.getData());
			
			if (compareValue == 0) {
				
				isIn = true;
				
			} else if (compareValue < 0) {
				
				isIn = this.contains(element, node.getLeft());
				
			} else {
				
				isIn = this.contains(element, node.getRight());
				
			}
			
		}
		
		return isIn;
		
	}
	
	/**
	 * @see tree.BinaryTree#remove(Object)
	 */
	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @see tree.BinaryTree#inOrderArray()
	 */
	@Override
	public T[] inOrderArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @see tree.BinaryTree#preOrderArray()
	 */
	@Override
	public T[] preOrderArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @see tree.BinaryTree#postOrderArray()
	 */
	@Override
	public T[] postOrderArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @see tree.BinaryTree#size()
	 */
	@Override
	public int size() {
		
		return this.size(this.root);
		
	}

	private int size(BinaryNode<T> node) {
		
		int size = 0;
		
		if (node != null) {
			
			size = 1 + this.size(node.getLeft()) + this.size(node.getRight());
			
		}
		
		return size;
		
	}
	
	/**
	 * @see tree.BinaryTree#height()
	 */
	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Get the value of the minimum element in the tree.
	 * 
	 * @return
	 * 		Value of the minimum element in the tree.
	 */
	public T min() {
		
		if (this.isEmpty()) {
			
			return null;
			
		}
		
		return this.min(this.root);
		
	}
	
	private T min(BinaryNode<T> node) {
		
		if (node.getLeft() == null) {
			
			return node.getData();
			
		}
		
		return this.min(node.getLeft());
		
	}

	/**
	 * Get the value of the maximum element in the tree.
	 * 
	 * @return
	 * 		Value of the maximum element in the tree.
	 */
	public T max() {
		
		if (this.isEmpty()) {
			
			return null;
			
		}
		
		return this.max(this.root);
		
	}
	
	private T max(BinaryNode<T> node) {
		
		if (node.getRight() == null) {
			
			return node.getData();
			
		}
		
		return this.min(node.getRight());
		
	}
	
	/**
	 * Get the floor of the given element in the tree.
	 * 
	 * @param element
	 * 		Element with floor has to be picked up.
	 * 
	 * @return
	 * 		Element's floor.
	 */
	public T floor(T element) {
		return null;
	}
	
	/**
	 * Get the ceiling of the given element in the tree.
	 * 
	 * @param element
	 * 		Element with ceiling has to be picked up.
	 * 
	 * @return
	 * 		Element's ceiling.
	 */
	public T ceiling(T element) {
		return null;
	}
	
	/**
	 * Remove the node with minimum value of the tree.
	 */
	public void removeMin() {
		
		if (!this.isEmpty()) {
			
			if (this.root.exitDegree() == 0 || this.root.getLeft() == null) {
				
				this.root = this.root.getRight();
				
			} else {
				
				this.removeMin(this.root, this.root.getLeft());
				
			}
			
		}
		
	}
	
	private void removeMin(BinaryNode<T> parentNode, BinaryNode<T> node) {
		
		if (node.getLeft() == null) {
			
			parentNode.setLeft(node.getRight());
			
		} else {
			
			this.removeMin(node, node.getLeft());
			
		}
		
	}
	
	/**
	 * Remove the node with maximum value of the tree.
	 */
	public void removeMax() {
		
		if (!this.isEmpty()) {
			
			if (this.root.exitDegree() == 0 || this.root.getRight() == null) {
				
				this.root = this.root.getLeft();
				
			} else {
				
				this.removeMax(this.root, this.root.getRight());
				
			}
			
		}
		
	}

	private void removeMax(BinaryNode<T> parentNode, BinaryNode<T> node) {
		
		if (node.getRight() == null) {
			
			parentNode.setRight(node.getLeft());
			
		} else {
			
			this.removeMin(node, node.getRight());
			
		}
		
		
	}

}
