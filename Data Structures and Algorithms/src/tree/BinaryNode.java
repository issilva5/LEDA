package tree;

public class BinaryNode<T> implements Node<T> {
	
	/**
	 * Node's value.
	 */
	private T data;
	
	/**
	 * Left node.
	 */
	private BinaryNode<T> left;
	
	/**
	 * Right node.
	 */
	private BinaryNode<T> right;
	
	/**
	 * Create a new node.
	 * 
	 * @param data
	 * 		Node's value.
	 */
	public BinaryNode(T data) {
		this.data = data;
	}
	
	/**
	 * @see tree.Node#exitDegree()
	 */
	@Override
	public int exitDegree() {
		return (this.left == null ? 0 : 1) + (this.right == null ? 0 : 1);
	}
	
	//Getters and Setters
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeft() {
		return this.left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return this.right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
	
}
