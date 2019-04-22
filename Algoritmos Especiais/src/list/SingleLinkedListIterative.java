package list;

@SuppressWarnings("unchecked")
public class SingleLinkedListIterative<T> implements List<T> {
	
	private Node<T> head;
	
	public SingleLinkedListIterative() {
		this.head = new Node<>();
	}
	
	@Override
	public boolean isEmpty() {
		return this.head.isNil();
	}

	@Override
	public int size() {
		
		int size = 0;
		Node<T> iterator = this.head;
		
		while (!iterator.isNil()) {
			
			size++;
			iterator = iterator.getNext();
			
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		
		Node<T> iterator = this.head;
		T returnValue = null;
		
		while (!iterator.isNil()) {
			
			if (iterator.getValue().equals(element)) {
				
				returnValue = iterator.getValue();
				break;
			}
			
			iterator = iterator.getNext();
			
		}
		
		return returnValue;
		
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
		
			Node<T> iterator = this.head;
			Node<T> newNode = new Node<>(element);
			
			if (this.isEmpty()) {
				
				this.head = newNode;
				
			} else {
				
				Node<T> previous = iterator;
				iterator = iterator.getNext();
				
				while (!iterator.isNil()) {
					
					previous = iterator;
					iterator = iterator.getNext();
					
				}
				
				previous.setNext(newNode);
				
			}
			
		}
		
	}

	@Override
	public void remove(T element) {
		
		if (!this.isEmpty()) {
		
			Node<T> iterator = this.head;
			Node<T> newNode = new Node<>(element);
			
			if (iterator.equals(newNode)) {
				
				this.head = this.head.getNext();
				
			} else {
			
				while (!iterator.isNil()) {
						
					if (iterator.getNext().equals(newNode)) {
						
						iterator.setNext(iterator.getNext().getNext());
		
						break;
						
					}
					
					iterator = iterator.getNext();
						
				}
				
			}
			
		}
		
	}

	@Override
	public T[] toArray() {
		
		T[] array = (T[]) new Object[this.size()];
		Node<T> iterator = this.head;
		int cont = 0;
		
		while (!iterator.isNil()) {
			
			array[cont] = iterator.getValue();
			iterator = iterator.getNext();
			cont++;
			
		}
		
		return array;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

}

@SuppressWarnings("unchecked")
class Node<T> {
	
	private T value;
	private Node<T> next;
	private Node<T> previous;
	
	public Node () {
		
	}
	
	public Node(T value) {
		this.value = value;
		this.next = new Node<>();
		this.previous = new Node<>();
	}

	public T getValue() {
		return this.value;
	}

	public Node<T> getNext() {
		return this.next;
	}
	
	public Node<T> getPrevious() {
		return this.previous;
	}
	
	public boolean isNil() {
		
		return this.value == null;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T> other = (Node<T>) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public void setNext(Node<T> node) {
		this.next = node;
	}

	public void setPrevious(Node<T> node) {
		this.previous = node;
	}
	
}
