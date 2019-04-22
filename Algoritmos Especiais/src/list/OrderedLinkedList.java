package list;

public class OrderedLinkedList<T extends Comparable<T> > extends SingleLinkedListIterative<T> {
	
	public OrderedLinkedList() {
		super();
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
		
			Node<T> iterator = super.getHead();
			Node<T> newNode = new Node<>(element);
			
			if (this.isEmpty()) {
				
				super.setHead(newNode);
				
			} else {
				
				if (newNode.getValue().compareTo(iterator.getValue()) < 0) {
					
					newNode.setNext(super.getHead());
					super.setHead(newNode);
					
				} else {
				
					Node<T> previous = iterator;
					iterator = iterator.getNext();
					
					while (!iterator.isNil() && newNode.getValue().compareTo(iterator.getValue()) > 0) {
						
						previous = iterator;
						iterator = iterator.getNext();
						
					}
					
					newNode.setNext(iterator);
					previous.setNext(newNode);
					
				}
				
			}
			
		}
		
	}

}
