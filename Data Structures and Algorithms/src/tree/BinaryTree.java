package tree;

public abstract class BinaryTree<T> implements Tree<T> {
	
	/**
	 * Tree's root.
	 */
	protected BinaryNode<T> root;
	
	/**
	 * Verify if the tree is empty or not.
	 * 
	 * @return
	 * 		TRUE if the tree is empty and FALSE otherwise.
	 */
	public boolean isEmpty() {
		
		return this.root == null;
		
	}
	
	/**
	 * Insert an element in the tree. Repeated elements are not inserted.
	 * 
	 * @param element
	 * 		Element to be inserted.
	 */
	public abstract void insert(T element);
	
	/**
	 * Verify if an element exits in the tree.
	 * 
	 * @param element
	 * 		Element to be verified.
	 * 
	 * @return
	 * 		TRUE if the element is in the tree and FALSE otherwise.
	 */
	public abstract boolean contains(T element);
	
	/**
	 * Remove an element of the tree.
	 * 
	 * @param element
	 * 		Element to be removed.
	 */
	public abstract void remove(T element);
	
	
	/**
	 * Go through the tree adding the elements into an array, following the order: leftNode, currentNode, rightNode.
	 * 
	 * @return
	 * 		Array containing the tree's elements in the specified order.
	 */
	public abstract T[] inOrderArray();
	
	/**
	 * Go through the tree adding the elements into an array, following the order: currentNode, leftNode, rightNode.
	 * 
	 * @return
	 * 		Array containing the tree's elements in the specified order.
	 */
	public abstract T[] preOrderArray();
	
	/**
	 * Go through the tree adding the elements into an array, following the order: leftNode, rightNode, currentNode.
	 * 
	 * @return
	 * 		Array containing the tree's elements in the specified order.
	 */
	public abstract T[] postOrderArray();
	
	/**
	 * Gives the size (quantity of elements) of the tree.
	 * 
	 * @return
	 * 		Tree's size.
	 */
	public abstract int size();
	
	/**
	 * Gives the tree's height.
	 * 
	 * @return
	 * 		Tree's height.
	 */
	public abstract int height();
	
}
