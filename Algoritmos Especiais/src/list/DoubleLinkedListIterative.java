package list;

public class DoubleLinkedListIterative<T> extends SingleLinkedListIterative<T> implements DoubleLinkedList<T> {
	
	private Node<T> tail;
	
	public DoubleLinkedListIterative() {
		super();
		this.tail = super.getHead();
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
		
			Node<T> insertNode = new Node<>(element);
			
			if (this.size() == 0) {
				
				this.tail = insertNode;
				super.setHead(this.tail);
				
			} else {
				
				this.tail.setNext(insertNode);
				insertNode.setPrevious(this.tail);
				this.tail = insertNode;
				
			}
			
		}
		
	}
	
	@Override
	public void remove(T element) {
		
		if (!this.isEmpty()) {
			
			Node<T> iterator = super.getHead();
			Node<T> newNode = new Node<>(element);
			
			if (iterator.equals(newNode)) {
				
				this.removeFirst();
				
			} else if (this.tail.equals(newNode)) {
				
				this.removeLast();
				
			} else {
				
				iterator = iterator.getNext();
				
				while (!iterator.isNil()) {
					
					if (iterator.equals(newNode)) {
						
						iterator.getNext().setPrevious(iterator.getPrevious());
						iterator.getPrevious().setNext(iterator.getNext());
						break;
						
					}
					
					iterator = iterator.getNext();
					
				}
				
			}
			
		}
	}

	@Override
	public void insertFirst(T element) {
		
		if (element != null) {
			
			Node<T> insertNode = new Node<>(element);
			
			if (this.size() == 0) {
				
				super.setHead(insertNode);
				this.tail = insertNode;
				
			} else {
				
				insertNode.setNext(super.getHead());
				super.setHead(insertNode);
				
			}
			
		}
		
	}

	@Override
	public void removeFirst() {
		
		if (!this.isEmpty()) {
			
			if (this.size() == 1) {
				
				super.setHead(new Node<T>());
				this.tail = super.getHead();
				
			} else {
			
				super.getHead().getNext().setPrevious(new Node<T>());
				super.setHead(super.getHead().getNext());
					
			}
			
		}
		
	}

	@Override
	public void removeLast() {
		
		if (!this.isEmpty()) {
			
			if (this.size() == 1) {
				
				this.tail = new Node<T>();
				super.setHead(this.tail);
				
			} else {
			
				this.tail.getPrevious().setNext(this.tail.getNext());
				this.tail = this.tail.getPrevious();
				
			}
		}
		
	}

}
