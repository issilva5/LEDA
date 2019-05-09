package tree;

public interface Node<T> {
	
	/**
	 * Return the exit degree of the node.
	 * The exit degree is the number of child nodes of the node.
	 * 
	 * @return
	 * 		Exit degree of the node.
	 */
	public int exitDegree();
	
}
